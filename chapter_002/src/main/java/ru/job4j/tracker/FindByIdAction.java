package ru.job4j.tracker;

public class FindByIdAction extends BaseAction {

    public FindByIdAction(int key, String name) {
        super(key, name);
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String id = input.askStr("");
        Item item = tracker.findById(id);
        if (item == null) {
            System.out.println("Заявка не найдена");
        } else {
            System.out.println(item.getId() + " " + item.getName());
        }
        return true;
    }
}
