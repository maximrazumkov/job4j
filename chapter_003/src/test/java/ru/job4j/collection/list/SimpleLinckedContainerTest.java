package ru.job4j.collection.list;

import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SimpleLinckedContainerTest {

    private SimpleLinkedList<Integer> container;

    @Before
    public void initConteiner() {
        container = new SimpleLinkedList<>();
        container.add(5);
        container.add(6);
        container.add(7);
        container.add(8);
    }

    @Test
    public void whenAddNewElement() {
        assertThat(container.size(), is(4));
        container.add(10);
        assertThat(container.size(), is(5));
        assertThat(container.get(4), is(5));
        assertThat(container.get(0), is(10));
    }

    @Test
    public void wheneDeleteFirstElement() {
        assertThat(container.size(), is(4));
        assertThat(container.get(0), is(8));
        container.delete(0);
        assertThat(container.get(0), is(7));
        assertThat(container.size(), is(3));
    }

    @Test
    public void wheneDeleteLastElement() {
        int lastIdx = container.size() - 1;
        assertThat(container.size(), is(4));
        assertThat(container.get(lastIdx), is(5));
        container.delete(lastIdx);
        assertThat(container.get(lastIdx - 1), is(6));
        assertThat(container.size(), is(3));
    }

    @Test
    public void wheneDeleteMiddleElement() {
        assertThat(container.size(), is(4));
        assertThat(container.get(2), is(6));
        container.delete(2);
        assertThat(container.get(2), is(5));
    }

    @Test
    public void whenAddNewElementAndNewSizeConteiner() {
        container.add(10);
        assertThat(container.size(), is(5));
        container.add(15);
        assertThat(container.size(), is(6));
    }

    @Test
    public void whenForEarchItr() {
        container.add(10);
        container.add(15);
        Iterator<Integer> itr = container.iterator();
        assertThat(itr.hasNext(), is(true));
        assertThat(itr.next(), is(15));
        assertThat(itr.hasNext(), is(true));
        assertThat(itr.next(), is(10));
        assertThat(itr.hasNext(), is(true));
        assertThat(itr.next(), is(8));
        assertThat(itr.hasNext(), is(true));
        assertThat(itr.next(), is(7));
        assertThat(itr.hasNext(), is(true));
        assertThat(itr.next(), is(6));
        assertThat(itr.hasNext(), is(true));
        assertThat(itr.next(), is(5));
        assertThat(itr.hasNext(), is(false));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenThrowNoSuchElementException() {
        Iterator<Integer> itr = container.iterator();
        itr.next();
        itr.next();
        itr.next();
        itr.next();
        itr.next();
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenThrowConcurrentModificationException() {
        Iterator<Integer> itr = container.iterator();
        itr.next();
        itr.next();
        container.add(10);
        itr.next();
    }
}
