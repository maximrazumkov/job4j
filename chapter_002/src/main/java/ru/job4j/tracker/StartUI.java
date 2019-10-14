package ru.job4j.tracker;

public class StartUI {
    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ");
            UserAction action = actions[select];
            run = action.execute(input, tracker);
            System.out.println(" ");
        }
    }

    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ====");
        System.out.print("Enter name: ");
        String name = input.askStr("");
        Item item = new Item(name);
        tracker.add(item);
        System.out.println("=== Created a new Item ====");
    }

    public static void deleteItem(Input input, Tracker tracker) {
        System.out.println("=== Delete Item ====");
        System.out.print("Enter id: ");
        String id = input.askStr("");
        boolean result = tracker.delete(id);
        if (result) {
            System.out.println("=== Deleted Item ====");
        } else {
            System.out.println("Заявка не найдена");
        }
    }

    public static void findByIdItem(Input input, Tracker tracker) {
        System.out.println("=== Find by id Item ====");
        System.out.print("Enter id: ");
        String id = input.askStr("");
        Item item = tracker.findById(id);
        if (item == null) {
            System.out.println("Заявка не найдена");
            System.out.println(" ");
            return;
        }
        System.out.println(item.getId() + " " + item.getName());
        System.out.println("=== Found by id Item ====");
    }

    public static void findByNameItem(Input input, Tracker tracker) {
        System.out.println("=== Find by name items ====");
        System.out.print("Enter name: ");
        String name = input.askStr("");
        Item[] items = tracker.findByName(name);
        if (items.length == 0) {
            System.out.println("Ниодной заявки не найдено");
            System.out.println(" ");
            return;
        }
        for (Item item : items) {
            System.out.println(item.getId() + " " + item.getName());
        }
        System.out.println("=== Found by name items ====");
    }

    public static void findAllItems(Tracker tracker) {
        System.out.println("=== Find All Item ====");
        Item[] items = tracker.findAll();
        if (items.length == 0) {
            System.out.println("Заявок нет");
            System.out.println(" ");
            return;
        }
        for (Item item : items) {
            System.out.println(item.getId() + " " + item.getName());
        }
        System.out.println("=== Found All Item ====");
    }

    public static void replaceItem(Input input, Tracker tracker) {
        System.out.println("=== Edit Item ====");
        System.out.print("Enter id: ");
        String id = input.askStr("");
        System.out.print("Введите название: ");
        String name = input.askStr("");
        Item item = new Item(name);
        item.setId(id);
        boolean result = tracker.replace(id, item);
        if (result) {
            System.out.println("=== Edited Item ====");
            System.out.println(item.getName() + " ");
        } else {
            System.out.println("Заявка не найдена");
        }
    }


    private void showMenu(UserAction[] actions) {
        System.out.println("Menu.");
        for (int index = 0; index < actions.length; index++) {
            System.out.println(actions[index].name());
        }
    }


    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Input validate = new ValidateInput(input);
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(0, "Add item"),
                new ReplaceAction(1, "Replace item"),
                new DeleteAction(2, "Delete item"),
                new FindAllAction(3, "Find all items"),
                new FindByIdAction(4, "Find by id item"),
                new FindByNameAction(5, "Find by name item"),
                new ExitAction(6, "Exit")
        };
        new StartUI().init(validate, tracker, actions);
    }
}
