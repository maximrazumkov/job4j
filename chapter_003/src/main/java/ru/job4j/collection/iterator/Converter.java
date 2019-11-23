package ru.job4j.collection.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Converter {
    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new Iterator<Integer>() {
            private Iterator<Integer> subIt;

            @Override
            public boolean hasNext() {
                boolean result = true;
                while (subIt == null || !subIt.hasNext()) {
                    if (!it.hasNext()) {
                        result = false;
                        break;
                    }
                    subIt = it.next();
                }
                return result;
            }

            @Override
            public Integer next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return subIt.next();
            }
        };
    }
}
