package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Converter {
    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new IteratorOfIterator(it);
    }

    private class IteratorOfIterator implements Iterator<Integer> {
        private final Iterator<Iterator<Integer>> it;
        private Iterator<Integer> subIt;

        public IteratorOfIterator(Iterator<Iterator<Integer>> it) {
            this.it = it;
            if (it.hasNext()) {
                subIt = it.next();
            }
        }

        @Override
        public boolean hasNext() {
            boolean result = subIt != null;
            while (result) {
                result = subIt.hasNext();
                if (subIt.hasNext()) {
                    break;
                }
                result = it.hasNext();
                if (result) {
                    subIt = it.next();
                }
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
    }
}
