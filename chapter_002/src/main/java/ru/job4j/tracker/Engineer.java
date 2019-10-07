package ru.job4j.tracker;

public class Engineer extends Profession {

    public Architecture developArchitecture() {
        return new Architecture();
    }


    public Documentation createDocumentation() {
        return new Documentation();
    }

}
