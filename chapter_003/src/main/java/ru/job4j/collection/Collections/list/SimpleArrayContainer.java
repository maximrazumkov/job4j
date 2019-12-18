package ru.job4j.collection.Collections.list;

import java.util.*;

public class SimpleArrayContainer<T> implements Iterable<T> {

    private int size = 5;

    private int modCount = 0;

    private int index = 0;

    private Object[] elements;

    public SimpleArrayContainer() {
        elements = new Object[size];
    }

    public SimpleArrayContainer(int qtyElements) {
        elements = qtyElements > 0 ? new Object[qtyElements] : new Object[size];
    }

    public void add(T element) {
        ensureCapacity();
        elements[index++] = element;
        ++modCount;
    }

    public T get(int index) {
        return (T) elements[index];
    }

    public int size() {
        return index;
    }

    private void ensureCapacity() {
        if (index == size) {
            size *= 2;
            elements = Arrays.copyOf(elements, size);
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<T> {

        private int expectedModCount = modCount;
        private int idx = 0;

        @Override
        public boolean hasNext() {
            boolean result = true;
            if (expectedModCount != modCount) {
                throw new ConcurrentModificationException();
            }
            if (idx == index) {
                result = false;
            }
            return result;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return (T) elements[idx++];
        }
    }
}
