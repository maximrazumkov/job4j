package ru.job4j.db.tracker;

import ru.job4j.tracker.ITracker;
import ru.job4j.tracker.Item;

import java.io.InputStream;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ExecutionException;

public class TrackerSQL implements ITracker<Integer>, AutoCloseable {

    private Connection connection;

    public boolean init() {
        try (InputStream in = TrackerSQL.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            createBD(config);
            this.connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")

            );
            createTablesDb();
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
        return this.connection != null;
    }

    private void createTablesDb() throws Exception {
        String query = String.format("create table if not exists item(id serial primary key, name varchar(250));");
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(query);
        } catch (Exception e) {
            throw e;
        }
    }

    private void createBD(Properties config) throws Exception {
        String url = config.getProperty("url");
        String nameDb = url.substring(url.lastIndexOf("/") + 1);
        String urlWithoutBd = url.substring(0, url.lastIndexOf("/") + 1);
        try (
            Connection connection = DriverManager.getConnection(
                    urlWithoutBd,
                    config.getProperty("username"),
                    config.getProperty("password")

            )
        ) {
            PreparedStatement preStatement = connection.prepareStatement("select 1 from pg_database where datname = ?");
            preStatement.setString(1, nameDb);
            ResultSet rs = preStatement.executeQuery();
            if (!rs.next()) {
                String query = String.format("create database %s with owner = postgres encoding = 'UTF8' TABLESPACE = pg_default", nameDb);
                Statement statement = connection.createStatement();
                statement.executeUpdate(query);
            }
        } catch (Exception e) {
            throw e;
        }
    }


    @Override
    public void close() throws Exception {
        try {
            connection.close();
        } catch (Exception e) {
            try  {
                connection.close();
            } catch (Exception t) {

            }
        } finally {
            connection = null;
        }
    }

    @Override
    public Item add(Item item) {
        String query = "insert into item(name) values (?)";
        try (PreparedStatement preStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            preStatement.setString(1, item.getName());
            preStatement.executeUpdate();
            ResultSet rs = preStatement.getGeneratedKeys();
            if (rs.next()) {
                item.setId(String.valueOf(rs.getInt("id")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return item;
    }

    @Override
    public boolean replace(Integer id, Item item) {
        String query = "update item set name = ? where id = ?";
        boolean result = true;
        try (PreparedStatement preStatement = connection.prepareStatement(query)) {
            preStatement.setString(1, item.getName());
            preStatement.setInt(2, id);
            int res = preStatement.executeUpdate();
            result = res == 0 ? false : true;
        } catch (Exception e) {
            e.printStackTrace();
            result = false;
        }
        return result;
    }

    @Override
    public boolean delete(Integer id) {
        String query = "delete from item where id = ?";
        boolean result = true;
        try (PreparedStatement preStatement = connection.prepareStatement(query)) {
            preStatement.setInt(1, id);
            int res = preStatement.executeUpdate();
            result = res == 0 ? false : true;
        } catch (Exception e) {
            e.printStackTrace();
            result = false;
        }
        return result;
    }

    @Override
    public Item findById(Integer id) {
        String query = "select * from item where id = ?";
        Item item = null;
        try (PreparedStatement preStatement = connection.prepareStatement(query)) {
            preStatement.setInt(1, id);
            ResultSet rs = preStatement.executeQuery();
            if (rs.next()) {
                item = new Item(String.valueOf(rs.getInt("id")), rs.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return item;
    }

    @Override
    public List<Item> findAll() {
        String query = "select * from item";
        List<Item> items = new LinkedList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                items.add(new Item(String.valueOf(rs.getInt("id")), rs.getString("name")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return items;
    }

    @Override
    public List<Item> findByName(String key) {
        String query = "select * from item where name = ?";
        List<Item> items = new LinkedList<>();
        try (PreparedStatement preStatement = connection.prepareStatement(query)) {
            preStatement.setString(1, key);
            ResultSet rs = preStatement.executeQuery();
            while (rs.next()) {
                items.add(new Item(String.valueOf(rs.getInt("id")), rs.getString("name")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return items;
    }
}
