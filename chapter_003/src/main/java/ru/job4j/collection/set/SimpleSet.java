package ru.job4j.collection.set;

import ru.job4j.collection.list.SimpleArrayContainer;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleSet<T> implements Iterable<T> {
    private SimpleArrayContainer<T> list = new SimpleArrayContainer<>();

    public SimpleSet() {
    }

    public boolean add(T value) {
        boolean result = false;
        if (!isDuplicate(value)) {
            list.add(value);
            result = true;
        }
        return result;
    }

    private boolean isDuplicate(T value) {
        boolean result = false;
        for (T val: list) {
            if (val.equals(value)) {
                result = true;
                break;
            }
        }
        return result;
    }

    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }
}
