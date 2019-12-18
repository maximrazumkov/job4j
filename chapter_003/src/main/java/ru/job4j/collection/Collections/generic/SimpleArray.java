package ru.job4j.collection.Collections.generic;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleArray<T> implements Iterable<T> {

    private Object[] elementData;
    private int index = 0;

    public SimpleArray(int index) {
        elementData = new Object[index];
    }

    public void add(T model) {
        elementData[index++] = model;
    }

    public void set(int index, T model) {
        elementData[index] = model;
    }

    public void remove(int index) {
        for (int i = index; i < elementData.length; ++i) {
            elementData[i] = null;
            if ((i + 1) < elementData.length) {
                elementData[i] = elementData[i + 1];
            }
        }
    }

    public T get(int index) {
        return (T) elementData[index];
    }

    public int size() {
        return elementData.length;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return this.index < elementData.length;
            }

            @Override
            public T next() {
                if (elementData.length == this.index) {
                    throw new NoSuchElementException();
                }
                return (T) elementData[this.index++];
            }
        };
    }
}
