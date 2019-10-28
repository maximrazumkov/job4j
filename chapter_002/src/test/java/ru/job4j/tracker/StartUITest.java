package ru.job4j.tracker;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.StringJoiner;
import java.util.function.Consumer;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class StartUITest {

    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    private final Consumer<String> output = new Consumer<String>() {
        private final PrintStream stdout = new PrintStream(out);

        @Override
        public void accept(String s) {
            stdout.println(s);
        }
    };

    @Test
    public void whenPrtMenu() {
        /*
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));
        */
        StubInput input = new StubInput(
                new String[] {"0"}
        );
        StubAction action = new StubAction(0, "Stub action", output::accept);
        new StartUI(output::accept).init(input, new Tracker(), new ArrayList<UserAction>() { { add(action); } });
        String expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add("Menu.")
                .add("0 : Stub action")
                .add(" ")
                .toString();
        assertThat(new String(out.toByteArray()), is(expect));
        //System.setOut(def);
    }

    @Test
    public void whenExit() {
        StubInput input = new StubInput(
                new String[] {"0"}
        );
        StubAction action = new StubAction(0, "Stub action", output::accept);
        new StartUI(output::accept).init(input, new Tracker(), new ArrayList<UserAction>() { { add(action); } });
        assertThat(action.isCall(), is(true));
    }
}
