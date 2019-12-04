package ru.job4j.collection.list;

import java.util.*;

public class SimpleLinkedList<T> implements Iterable<T> {

    private int size = 0;
    private int modCount = 0;
    private Node<T> first;

    public SimpleLinkedList() {
    }

    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = first;
        first = newNode;
        ++size;
        ++modCount;
    }

    public T get(int index) {
        Node<T> res = first;
        for (int i = 0; i < index; ++i) {
            res = res.next;
        }
        return res.data;
    }

    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<T> {

        private int expectedModCount = modCount;
        private Node<T> currentNode = first;

        @Override
        public boolean hasNext() {
            boolean result = false;
            if (expectedModCount != modCount) {
                throw new ConcurrentModificationException();
            }
            if (currentNode != null) {
                result = true;
            }
            return result;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T result = currentNode.data;
            currentNode = currentNode.next;
            return result;
        }
    }

    private static class Node<T> {
        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }
}
