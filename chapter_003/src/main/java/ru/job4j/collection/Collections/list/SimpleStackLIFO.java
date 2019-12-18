package ru.job4j.collection.Collections.list;

public class SimpleStackLIFO<T> {

    private SimpleLinkedList<T> queue = new SimpleLinkedList<>();

    public T poll() {
        return queue.delete(0);
    }

    public void push(T value) {
        queue.add(value);
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public int size() {
        return queue.size();
    }
}
