package ru.job4j.tracker;

public class ReplaceAction implements UserAction {
    @Override
    public String name() {
        return "=== Edit Item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.print("Enter id: ");
        String id = input.askStr("");
        System.out.print("Введите название: ");
        String name = input.askStr("");
        Item item = new Item(name);
        item.setId(id);
        tracker.replace(id, item);
        return true;
    }
}
