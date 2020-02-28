package ru.job4j.db.magnit.implementation;

import ru.job4j.db.magnit.interfaces.ServiceDB;
import ru.job4j.db.magnit.models.Entry;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class StoreSQL implements ServiceDB, AutoCloseable {
    private final Connection connect;

    public StoreSQL(Connection connect) {
        this.connect = connect;
    }

    public void generate(int size) {
        String deleteQuery = "delete from Entry";
        List<Entry> entries = load();
        try (
                Statement st = connect.createStatement();
                PreparedStatement ps = connect.prepareStatement("insert into Entry(id) values (?)");
        ) {
            connect.setAutoCommit(false);
            if (!entries.isEmpty()) {
                int resultDelete = st.executeUpdate(deleteQuery);
                if (resultDelete == 0) {
                    throw new RuntimeException("не удалось очистить базу");
                }
            }
            for (int i = 0; i < size; ++i) {
                ps.setInt(1, i);
                ps.addBatch();
            }
            ps.executeBatch();
            connect.commit();
            connect.setAutoCommit(true);
        } catch (Exception e) {
            try {
                connect.rollback();
                connect.setAutoCommit(true);
            } catch (Exception t) {
                t.printStackTrace();
            }
            e.printStackTrace();
        }
    }

    public List<Entry> load() {
        String query = "select * from Entry";
        List<Entry> entries = new LinkedList<>();
        try (Statement st = connect.createStatement()) {
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                entries.add(new Entry(rs.getInt(1)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return entries;
    }

    @Override
    public void close() throws Exception {
        if (connect != null) {
            connect.close();
        }
    }
}
