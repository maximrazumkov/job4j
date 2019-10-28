package ru.job4j.tracker;

import java.util.List;
import java.util.function.Consumer;

public class FindAllAction extends BaseAction {

    public FindAllAction(int key, String name, Consumer<String> output) {
        super(key, name, output);
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        List<Item> items = tracker.findAll();
        for (Item item : items) {
            super.getOutput().accept(item.getId() + " " + item.getName());
        }
        return true;
    }
}
