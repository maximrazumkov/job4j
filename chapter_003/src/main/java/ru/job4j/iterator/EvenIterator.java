package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenIterator implements Iterator<Integer> {
    private final int[] values;
    private int index = 0;

    public EvenIterator(int[] values) {
        this.values = values;
    }

    @Override
    public boolean hasNext() {
        boolean result = false;
        for (int i = index; i < values.length; ++i) {
            if ((values[i] % 2) == 0) {
                result = true;
                break;
            }
        }
        return result;
    }

    @Override
    public Integer next() {
        while(index < values.length && (values[index] % 2) != 0) {
            ++index;
        }
        if (index == values.length) {
            throw new NoSuchElementException();
        }
        return values[index++];
    }
}
