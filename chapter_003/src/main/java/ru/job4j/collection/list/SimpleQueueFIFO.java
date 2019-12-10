package ru.job4j.collection.list;

public class SimpleQueueFIFO<T> {

    SimpleStackLIFO<T> in = new SimpleStackLIFO<>();
    SimpleStackLIFO<T> out = new SimpleStackLIFO<>();

    public T poll() {
        if (out.isEmpty()) {
            inToOut();
        }
        return out.poll();
    }

    public void push(T value) {
        in.push(value);
    }

    private void inToOut() {
        int size = in.size();
        for (int i = 0; i < size; ++i) {
            out.push(in.poll());
        }
    }

    public int size() {
        return in.size() + out.size();
    }
}
