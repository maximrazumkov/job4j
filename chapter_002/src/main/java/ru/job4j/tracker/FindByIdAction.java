package ru.job4j.tracker;

import java.util.function.Consumer;

public class FindByIdAction extends BaseAction {

    public FindByIdAction(int key, String name, Consumer<String> output) {
        super(key, name, output);
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String id = input.askStr("");
        Item item = tracker.findById(id);
        if (item == null) {
            super.getOutput().accept("Заявка не найдена");
        } else {
            super.getOutput().accept(item.getId() + " " + item.getName());
        }
        return true;
    }
}
