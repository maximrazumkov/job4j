package ru.job4j.oop;

import ru.job4j.oop.Animal;

public class Predator extends Animal {

    public Predator() {
        System.out.println("Predator");
    }

    public Predator(String name) {
        super(name);
    }
}
