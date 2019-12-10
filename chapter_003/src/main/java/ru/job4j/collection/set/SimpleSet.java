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
        Iterator<T> itr = list.iterator();
        while (itr.hasNext()) {
            T val = itr.next();
            if (val.equals(value)) {
                result = true;
                break;
            }
        }
        return result;
    }

    @Override
    public Iterator<T> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<T> {

        private int currentIdx = 0;

        @Override
        public boolean hasNext() {
            return currentIdx < list.size();
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return list.get(currentIdx++);
        }
    }
}
