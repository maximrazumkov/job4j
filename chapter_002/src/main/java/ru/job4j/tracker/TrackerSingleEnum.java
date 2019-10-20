package ru.job4j.tracker;

import ru.job4j.oop.Transport;

import java.util.List;

public enum TrackerSingleEnum {
    INSTANCE;

    private final Tracker tracker = new Tracker();

    public Item add(Item item) {
        return  this.tracker.add(item);
    }

    public boolean replace(String id, Item item) {
        return this.tracker.replace(id, item);
    }

    public boolean delete(String id) {
        return this.tracker.delete(id);
    }

    public List<Item> findAll() {
        return this.tracker.findAll();
    }

    public List<Item> findByName(String key) {
        return this.tracker.findByName(key);
    }

    public Item findById(String id) {
        return this.tracker.findById(id);
    }
}
