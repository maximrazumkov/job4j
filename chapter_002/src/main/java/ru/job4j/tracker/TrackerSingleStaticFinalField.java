package ru.job4j.tracker;

import java.util.List;

public class TrackerSingleStaticFinalField {
    private static final TrackerSingleStaticFinalField instance = new TrackerSingleStaticFinalField();
    private final Tracker tracker = new Tracker();

    private TrackerSingleStaticFinalField() {
    }

    public static TrackerSingleStaticFinalField getInstance() {
        return instance;
    }

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
