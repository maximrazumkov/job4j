package ru.job4j.tracker;

public class DeleteAction extends BaseAction {

    public DeleteAction(int key, String name) {
        super(key, name);
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.print("Enter id: ");
        String id = input.askStr("");
        tracker.delete(id);
        return true;
    }
}
