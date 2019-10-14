package ru.job4j.oop;

import ru.job4j.oop.Predator;

public class Tiger extends Predator {

    public Tiger() {
        System.out.println("Tiger");
    }

    public Tiger(String name) {
        super(name);
    }
}
