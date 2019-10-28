package ru.job4j.tracker;

import java.util.function.Consumer;

public class ReplaceAction extends BaseAction {

    public ReplaceAction(int key, String name, Consumer<String> output) {
        super(key, name, output);
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        super.getOutput().accept("Enter id: ");
        String id = input.askStr("");
        super.getOutput().accept("Введите название: ");
        String name = input.askStr("");
        Item item = new Item(name);
        item.setId(id);
        tracker.replace(id, item);
        return true;
    }
}
