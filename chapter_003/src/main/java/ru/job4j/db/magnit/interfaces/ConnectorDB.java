package ru.job4j.db.magnit.interfaces;

import java.sql.Connection;

public interface ConnectorDB {
    Connection getConnection();
}
