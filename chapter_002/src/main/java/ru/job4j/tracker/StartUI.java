package ru.job4j.tracker;

public class StartUI {
    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            int select;
            do {
                this.showMenu();
                select = Integer.valueOf(input.askStr(""));
                if (select >= 0 && select <= 6) {
                    break;
                }
                System.out.println("Выберите существующий пункт меню.");
            } while (true);
            if (select == 0) {
                createItem(input, tracker);
            } else if (select == 1) {
                findAllItems(tracker);
            } else if (select == 2) {
                replaceItem(input, tracker);
            } else if (select == 3) {
                deleteItem(input, tracker);
            } else if (select == 4) {
                findByIdItem(input, tracker);
            } else if (select == 5) {
                findByNameItem(input, tracker);
            } else if (select == 6) {
                run = false;
            }
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


    private void showMenu() {
        System.out.println("Menu.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
        System.out.print("Select: ");
    }


    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}
