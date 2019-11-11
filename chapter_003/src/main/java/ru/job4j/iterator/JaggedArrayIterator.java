package ru.job4j.iterator;

import java.util.Iterator;

public class JaggedArrayIterator implements Iterator<Integer> {

    private final int[][] values;
    private int i = 0;
    private int j = 0;

    public JaggedArrayIterator(int[][] values) {
        this.values = values;
    }

    @Override
    public boolean hasNext() {
        return i < values.length;
    }

    @Override
    public Integer next() {
        Integer result = values[i][j++];
        if (j == values[i].length) {
            j = 0;
            ++i;
        }
        return result;
    }
}
