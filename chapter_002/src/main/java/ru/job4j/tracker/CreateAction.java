package ru.job4j.tracker;

import java.util.function.Consumer;

public class CreateAction extends BaseAction {

    public CreateAction(int key, String name, Consumer<String> output) {
        super(key, name, output);
    }

    @Override
    public boolean execute(Input input, ITracker tracker) {
        super.getOutput().accept("Enter name: ");
        String name = input.askStr("");
        Item item = new Item(name);
        tracker.add(item);
        return true;
    }
}
