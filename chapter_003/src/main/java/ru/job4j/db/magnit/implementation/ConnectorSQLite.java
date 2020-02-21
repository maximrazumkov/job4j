package ru.job4j.db.magnit.implementation;

import ru.job4j.db.magnit.interfaces.ConnectorDB;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.Statement;

public class ConnectorSQLite implements ConnectorDB {
    private final Config config;

    public ConnectorSQLite(Config config) {
        this.config = config;
    }

    @Override
    public Connection getConnection() {
        try {
            String url = config.get("url");
            Connection conn = DriverManager.getConnection(url);
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
            }
            String checkDB = config.get("checkDB");
            if (checkDB.equals("true")) {
                checkDB(conn);
            }
            return conn;
        } catch (Exception e) {
            throw new RuntimeException("Не удалось установить соединение с БД", e);
        }
    }

    private boolean checkDB(Connection conn) {
        String query = String.format("CREATE TABLE if not exists Entry (id INTEGER PRIMARY KEY);");
        try (Statement statement = conn.createStatement()) {
            boolean result = statement.execute(query);
            return result;
        } catch (Exception e) {
            throw new RuntimeException("Не удалось проверить БД при установке соединения", e);
        }
    }
}
