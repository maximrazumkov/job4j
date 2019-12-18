package ru.job4j.collection.tree;

import java.util.*;

public class Tree<E extends Comparable<E>> implements SimpleTree<E> {

    private Node<E> root;

    public Tree(E root) {
        this.root = new Node<>(root);
    }

    public boolean isBinary() {
        return false;
    }

    @Override
    public boolean add(E parent, E child) {
        boolean result = false;
        Optional<Node<E>> opt = findBy(parent);
        if (opt.isPresent()) {
            Node<E> par = opt.get();
            List<Node<E>> children = par.leaves();
            Node<E> newChild = new Node<>(child);
            if (!children.contains(newChild)) {
                par.add(new Node<>(child));
                result = true;
            }
        }
        return result;
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.eqValue(value)) {
                rsl = Optional.of(el);
                break;
            }
            for (Node<E> child : el.leaves()) {
                data.offer(child);
            }
        }
        return rsl;
    }

    @Override
    public Iterator<E> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<E> {

        Queue<Node<E>> queue = new LinkedList<Node<E>>() {{offer(root);}};

        @Override
        public boolean hasNext() {
            return !queue.isEmpty();
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Node<E> node = queue.poll();
            for (Node<E> child : node.leaves()) {
                queue.offer(child);
            }
            return node.getValue();
        }
    }
}
