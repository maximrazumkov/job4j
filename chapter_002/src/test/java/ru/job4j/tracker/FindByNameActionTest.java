package ru.job4j.tracker;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringJoiner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FindByNameActionTest {
    @Test
    public void whenCheckOutput() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));
        Tracker tracker = new Tracker();
        Item[] items = new Item[3];
        items[0] = new Item("fix bug");
        items[1] = new Item("fix bug");
        items[2] = new Item("hot fix");
        tracker.add(items[0]);
        tracker.add(items[1]);
        tracker.add(items[2]);
        FindByNameAction act = new FindByNameAction(5, "Find by name item");
        act.execute(new StubInput(new String[] {"fix bug"}), tracker);
        String expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add(items[0].getId() + " " + items[0].getName())
                .add(items[1].getId() + " " + items[1].getName())
                .toString();
        assertThat(new String(out.toByteArray()), is(expect));
        System.setOut(def);
    }
}
