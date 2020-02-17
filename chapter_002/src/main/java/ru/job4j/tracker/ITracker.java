package ru.job4j.tracker;

import java.util.List;

public interface ITracker<T> {
    Item add(Item item);
    boolean replace(T id, Item item);
    boolean delete(T id);
    List<Item> findAll();
    List<Item> findByName(String key);
    Item findById(T id);
}
