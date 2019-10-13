package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    @Override
    public String name() {
        return "=== Delete Item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Delete Item ====");
        System.out.print("Enter id: ");
        String id = input.askStr("");
        tracker.delete(id);
        return true;
    }
}
