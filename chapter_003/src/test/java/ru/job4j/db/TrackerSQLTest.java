package ru.job4j.db;

import org.junit.Test;
import ru.job4j.db.tracker.TrackerSQL;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TrackerSQLTest {
    @Test
    public void checkConnection() {
        TrackerSQL sql = new TrackerSQL();
        assertThat(sql.init(), is(true));
    }
}
