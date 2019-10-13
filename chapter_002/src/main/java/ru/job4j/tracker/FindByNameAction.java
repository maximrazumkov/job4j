package ru.job4j.tracker;

public class FindByNameAction implements UserAction {
    @Override
    public String name() {
        return "=== Find by name items ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("");
        Item[] items = tracker.findByName(name);
        for (Item item : items) {
            System.out.println(item.getId() + " " + item.getName());
        }
        return true;
    }
}
