package ru.job4j.tracker;

import java.util.List;

public class TrackerSingleStaticFinalClass {
    private final Tracker tracker = new Tracker();

    private TrackerSingleStaticFinalClass() {
    }

    public static TrackerSingleStaticFinalClass getInstance() {
        return Holder.INSTANCE;
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

    private static final class Holder {
        private static final TrackerSingleStaticFinalClass INSTANCE = new TrackerSingleStaticFinalClass();
    }

    public static void main(String[] args) {
        TrackerSingleStaticFinalClass tracker = TrackerSingleStaticFinalClass.getInstance();
    }
}
