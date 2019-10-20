package ru.job4j.tracker;

import java.util.List;

public class FindByNameAction extends BaseAction {

    public FindByNameAction(int key, String name) {
        super(key, name);
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("");
        List<Item> items = tracker.findByName(name);
        for (Item item : items) {
            System.out.println(item.getId() + " " + item.getName());
        }
        return true;
    }
}
