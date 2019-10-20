package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class StartUI {
    public void init(Input input, Tracker tracker, ArrayList<UserAction> actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ");
            UserAction action = actions.get(select);
            run = action.execute(input, tracker);
            System.out.println(" ");
        }
    }

    private void showMenu(ArrayList<UserAction> actions) {
        System.out.println("Menu.");
        actions.forEach(userAction -> System.out.println(userAction.name()));
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Input validate = new ValidateInput(input);
        Tracker tracker = new Tracker();
        ArrayList<UserAction> actions = new ArrayList<UserAction>(){{
                add(new CreateAction(0, "Add item"));
                add(new ReplaceAction(1, "Replace item"));
                add(new DeleteAction(2, "Delete item"));
                add(new FindAllAction(3, "Find all items"));
                add(new FindByIdAction(4, "Find by id item"));
                add(new FindByNameAction(5, "Find by name item"));
                add(new ExitAction(6, "Exit"));
        }};
        new StartUI().init(validate, tracker, actions);
    }
}
