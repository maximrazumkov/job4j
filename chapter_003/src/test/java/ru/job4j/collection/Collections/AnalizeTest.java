package ru.job4j.collection.Collections;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AnalizeTest {
    @Test
    public void whenListWothoutChangedAddedDeleted() {
        List<Analize.User> current = new LinkedList<>();
        current.add(new Analize.User(1, "Fedy"));
        current.add(new Analize.User(2, "Pety"));
        current.add(new Analize.User(3, "Stepa"));
        List<Analize.User> previous = new LinkedList<>();
        previous.add(new Analize.User(1, "Fedy"));
        previous.add(new Analize.User(2, "Pety"));
        previous.add(new Analize.User(3, "Stepa"));
        Analize.Info info = new Analize().diff(previous, current);
        assertThat(info.added, is(0));
        assertThat(info.changed, is(0));
        assertThat(info.deleted, is(0));
    }

    @Test
    public void whenListChangedAddedDeleted() {
        List<Analize.User> current = new LinkedList<>();
        current.add(new Analize.User(1, "Fedya"));
        current.add(new Analize.User(2, "Pety"));
        current.add(new Analize.User(4, "Pety777"));
        current.add(new Analize.User(5, "Stepa999"));
        List<Analize.User> previous = new LinkedList<>();
        previous.add(new Analize.User(1, "Fedy"));
        previous.add(new Analize.User(2, "Pety"));
        previous.add(new Analize.User(3, "Stepa"));
        Analize.Info info = new Analize().diff(previous, current);
        assertThat(info.added, is(2));
        assertThat(info.changed, is(1));
        assertThat(info.deleted, is(1));
    }

    @Test
    public void whenListAllDeleted() {
        List<Analize.User> current = new LinkedList<>();
        List<Analize.User> previous = new LinkedList<>();
        previous.add(new Analize.User(1, "Fedy"));
        previous.add(new Analize.User(2, "Pety"));
        previous.add(new Analize.User(3, "Stepa"));
        Analize.Info info = new Analize().diff(previous, current);
        assertThat(info.added, is(0));
        assertThat(info.changed, is(0));
        assertThat(info.deleted, is(3));
    }

    @Test
    public void whenListAllChanged() {
        List<Analize.User> current = new LinkedList<>();
        current.add(new Analize.User(1, "Fedya"));
        current.add(new Analize.User(2, "Petya"));
        current.add(new Analize.User(3, "Pety777"));
        List<Analize.User> previous = new LinkedList<>();
        previous.add(new Analize.User(1, "Fedy"));
        previous.add(new Analize.User(2, "Pety"));
        previous.add(new Analize.User(3, "Stepa"));
        Analize.Info info = new Analize().diff(previous, current);
        assertThat(info.added, is(0));
        assertThat(info.changed, is(3));
        assertThat(info.deleted, is(0));
    }
}
