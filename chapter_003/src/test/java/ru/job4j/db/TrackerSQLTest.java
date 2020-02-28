package ru.job4j.db;

import org.junit.Test;
import ru.job4j.db.tracker.ConnectionRollback;
import ru.job4j.db.tracker.IniterConnection;
import ru.job4j.db.tracker.TrackerSQL;
import ru.job4j.tracker.Item;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TrackerSQLTest {
    @Test
    public void checkConnection() throws Exception {
        TrackerSQL sql = new TrackerSQL(ConnectionRollback.create(new IniterConnection().init()));
        //assertThat(sql.init(), is(true));
    }

    public Connection init() {
        try (InputStream in = TrackerSQL.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            return DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")

            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Test
    public void createItem() throws Exception {
        try (TrackerSQL tracker = new TrackerSQL(ConnectionRollback.create(this.init()))) {
            tracker.add(new Item("name", "desc"));
            assertThat(tracker.findByName("desc").size(), is(1));
        }
    }

    @Test
    public void deleteItem() throws Exception {
        try (TrackerSQL tracker = new TrackerSQL(ConnectionRollback.create(this.init()))) {
            Item item = new Item("name", "desc");
            tracker.add(item);
            assertThat(tracker.findByName("desc").size(), is(1));
            tracker.delete(Integer.valueOf(item.getId()));
            assertThat(tracker.findByName("desc").size(), is(0));
        }
    }

    @Test
    public void replaceItem() throws Exception {
        try (TrackerSQL tracker = new TrackerSQL(ConnectionRollback.create(this.init()))) {
            Item item = new Item("name", "desc");
            tracker.add(item);
            assertThat(tracker.findByName("desc").size(), is(1));
            item.setName("new Desc");
            tracker.replace(Integer.valueOf(item.getId()), item);
            assertThat(tracker.findByName("desc").size(), is(0));
            assertThat(tracker.findByName("new Desc").size(), is(1));
        }
    }

    @Test
    public void findByIdItem() throws Exception {
        try (TrackerSQL tracker = new TrackerSQL(ConnectionRollback.create(this.init()))) {
            Item item = new Item("desc");
            tracker.add(item);
            assertThat(tracker.findById(Integer.valueOf(item.getId())), is(item));
        }
    }

    @Test
    public void findByNameItem() throws Exception {
        try (TrackerSQL tracker = new TrackerSQL(ConnectionRollback.create(this.init()))) {
            Item item = new Item("desc");
            tracker.add(item);
            tracker.add(item);
            assertThat(tracker.findByName("desc").size(), is(2));
        }
    }

    @Test
    public void findAllItem() throws Exception {
        try (TrackerSQL tracker = new TrackerSQL(ConnectionRollback.create(this.init()))) {
            Item item1 = new Item("desc");
            tracker.add(item1);
            Item item2 = new Item("another desc");
            tracker.add(item2);
            assertThat(tracker.findAll().size(), is(2));
        }
    }

}
