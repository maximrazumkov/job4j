package ru.job4j.collection.list;

public class SimpleQueueLIFO<T> {

    private SimpleLinkedList<T> queue = new SimpleLinkedList<>();

    public T poll() {
        return queue.delete(0);
    }

    public void push(T value) {
        queue.add(value);
    }

    public int size() {
        return queue.size();
    }
}
