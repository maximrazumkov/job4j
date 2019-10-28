package ru.job4j.tracker;

import java.util.function.Consumer;

public interface UserAction {
    int key();
    String name();
    Consumer<String> getOutput();
    boolean execute(Input input, Tracker tracker);
}
