package ru.job4j.tracker;

import java.util.function.Consumer;

public class DeleteAction extends BaseAction {

    public DeleteAction(int key, String name, Consumer<String> output) {
        super(key, name, output);
    }

    @Override
    public boolean execute(Input input, ITracker tracker) {
        super.getOutput().accept("Enter id: ");
        String id = input.askStr("");
        tracker.delete(id);
        return true;
    }
}
