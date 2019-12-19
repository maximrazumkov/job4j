package ru.job4j.collection.tree;

import java.util.*;

public class Tree<E extends Comparable<E>> implements SimpleTree<E> {

    private Node<E> root;

    public Tree(E root) {
        this.root = new Node<>(root);
    }

    public boolean isBinary() {
        boolean result = true;
        Queue<Node<E>> nodes = new LinkedList<>();
        nodes.offer(root);
        while (!nodes.isEmpty()) {
            Node<E> node = nodes.poll();
            List<Node<E>> children = node.leaves();
            if (children.size() > 2) {
                result = false;
                break;
            }
            for (Node<E> child : children) {
                nodes.offer(child);
            }
        }
        return result;
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

        Node<E> node;
        Queue<Node<E>> queue = new LinkedList<Node<E>>() { { offer(root); } };

        @Override
        public boolean hasNext() {
            return !queue.isEmpty();
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            node = queue.poll();
            for (Node<E> child : node.leaves()) {
                queue.offer(child);
            }
            return node.getValue();
        }
    }
}
