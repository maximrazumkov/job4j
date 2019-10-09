package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {
    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            int select;
            do {
                this.showMenu();
                select = Integer.valueOf(scanner.nextLine());
                if (select >= 0 && select <= 6) {
                    break;
                }
                System.out.println("Выберите существующий пункт меню.");
            } while (true);
            if (select == 0) {
                addItem(scanner, tracker);
            } else if (select == 1) {
                findAllItems(scanner, tracker);
            } else if (select == 2) {
                replaceItems(scanner, tracker);
            } else if (select == 3) {
                deleteItem(scanner, tracker);
            } else if (select == 4) {
                findByIdItem(scanner, tracker);
            } else if (select == 5) {
                findByNameItem(scanner, tracker);
            } else if (select == 6) {
                run = false;
            }
            System.out.println(" ");
        }
    }

    private void addItem(Scanner scanner, Tracker tracker) {
        System.out.println("=== Create a new Item ====");
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        Item item = new Item(name);
        tracker.add(item);
        System.out.println("=== Created a new Item ====");
    }

    private void deleteItem(Scanner scanner, Tracker tracker) {
        System.out.println("=== Delete Item ====");
        System.out.print("Enter id: ");
        String id = scanner.nextLine();
        boolean result = tracker.delete(id);
        if (result) {
            System.out.println("=== Deleted Item ====");
        } else {
            System.out.println("Заявка не найдена");
        }
    }

    private void findByIdItem(Scanner scanner, Tracker tracker) {
        System.out.println("=== Find by id Item ====");
        System.out.print("Enter id: ");
        String id = scanner.nextLine();
        Item item = tracker.findById(id);
        if (item == null) {
            System.out.println("Заявка не найдена");
            System.out.println(" ");
            return;
        }
        System.out.println(item.getId() + " " + item.getName());
        System.out.println("=== Found by id Item ====");
    }

    private void findByNameItem(Scanner scanner, Tracker tracker) {
        System.out.println("=== Find by name items ====");
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
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

    private void findAllItems(Scanner scanner, Tracker tracker) {
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

    private void replaceItems(Scanner scanner, Tracker tracker) {
        System.out.println("=== Edit Item ====");
        System.out.print("Enter id: ");
        String id = scanner.nextLine();
        System.out.print("Введите название: ");
        String name = scanner.nextLine();
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
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}
