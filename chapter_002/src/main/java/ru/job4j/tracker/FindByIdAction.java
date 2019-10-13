package ru.job4j.tracker;

public class FindByIdAction implements UserAction {
    @Override
    public String name() {
        return "=== Find by id Item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Find by id Item ====");
        System.out.print("Enter id: ");
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
