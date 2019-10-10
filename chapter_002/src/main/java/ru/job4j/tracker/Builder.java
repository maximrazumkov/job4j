package ru.job4j.tracker;

public class Builder extends Engineer {

    public Constraction build(Material material) {
        return new Constraction();
    }

    public void tearDown(Constraction construction) {

    }
}
