package ru.job4j.collection.map;

import java.util.*;

public class SimpleHashMap<K, V> implements Iterable<SimpleHashMap.Entry<K, V>> {

    private int size = 256;
    private int count = 0;
    private int mod = 0;

    private Entry<K, V>[] entrys = new Entry[size];

    public boolean insert(K key, V value) {
        resize();
        boolean result = get(key) == null;
        int idx = 0;
        if (result) {
            idx = calcEntryNum(key);
            result = entrys[idx] == null;
       }
        if (result) {
            entrys[idx] = new Entry<K, V>(key, value);
            ++count;
            ++mod;
        }
        return result;
    }

    public V get(K key) {
        int idx = calcEntryNum(key);
        K k = (entrys[idx] != null) ? entrys[idx].key : null;
        return key.equals(k) ? entrys[idx].value : null;
    }

    public boolean delete(K key) {
        int idx = calcEntryNum(key);
        boolean result = entrys[idx] != null;
        if (result) {
            entrys[idx] = null;
            ++mod;
            --count;
        }
        return result;
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    private void resize() {
        if (entrys.length == count) {
            size *= 2;
            Entry<K, V>[] newEntry = new Entry[size];
            for (Entry<K, V> old : entrys) {
                int idx = calcEntryNum(old.key);
                newEntry[idx] = old;
            }
            entrys = newEntry;
        }
    }

    private int calcEntryNum(K key) {
        int result = -1;
        if (key == null) {
            result = 0;
        }
        if (result != 0) {
            int hash = key.hashCode();
            result = hash % size;
        }
        return result;
    }

    static class Entry<K, V> {
        K key;
        V value;

        public Entry() {
        }

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }

    @Override
    public Iterator<Entry<K, V>> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<Entry<K, V>> {

        private int currMod = mod;
        private int currIdx = 0;
        private int remeining = count;

        @Override
        public boolean hasNext() {
            return remeining > 0;
        }

        @Override
        public Entry<K, V> next() {
            if (currMod != mod) {
                throw new ConcurrentModificationException();
            }
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            for (int i = currIdx; remeining != 0; ++i) {
                if (entrys[i] != null) {
                    currIdx = i;
                    break;
                }
            }
            --remeining;
            return entrys[currIdx++];
        }
    }

}
