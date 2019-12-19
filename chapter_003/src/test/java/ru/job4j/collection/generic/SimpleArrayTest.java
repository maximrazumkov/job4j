package ru.job4j.collection.generic;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class SimpleArrayTest {
    private SimpleArray simpleArray;

    @Before
    public void initSimpleArray() {
        simpleArray = new SimpleArray<>(4);
        simpleArray.add(1);
        simpleArray.add(5);
        simpleArray.add(10);
    }

    @Test
    public void whenAddAndGetElementInt() {
        simpleArray.add(10);
        assertThat(simpleArray.get(3), is(10));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void whenAddElementIntArrayIndexOutOfBounds() {
        simpleArray.add(15);
        simpleArray.add(20);
    }

    @Test
    public void whenSetAndGetElementInt() {
        simpleArray.set(0, 10);
        assertThat(simpleArray.get(0), is(10));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void whenSetElementIntArrayIndexOutOfBounds() {
        simpleArray.set(10, 10);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void whenGetElementIntArrayIndexOutOfBounds() {
        simpleArray.get(10);
    }
    @Test
    public void whenRemoveFirstElementInt() {
        simpleArray.remove(0);
        assertThat(simpleArray.get(0), is(5));
        assertThat(simpleArray.get(1), is(10));
        assertNull(simpleArray.get(2));
    }

    @Test
    public void whenRemoveLastElementInt() {
        simpleArray.remove(2);
        assertThat(simpleArray.get(0), is(1));
        assertThat(simpleArray.get(1), is(5));
        assertNull(simpleArray.get(2));
    }

    @Test
    public void whenRemoveMidleElementInt() {
        simpleArray.remove(1);
        assertThat(simpleArray.get(0), is(1));
        assertThat(simpleArray.get(1), is(10));
        assertNull(simpleArray.get(2));
    }

    @Test
    public void hasNextNextSequentialInvocation() {
        Iterator<Integer> it = simpleArray.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(5));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(10));
        assertThat(it.hasNext(), is(true));
        assertNull(it.next());
        assertThat(it.hasNext(), is(false));
    }

    @Test(expected = NoSuchElementException.class)
    public void invocationOfNextMethodShouldThrowNoSuchElementException() {
        Iterator<Integer> it = simpleArray.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(5));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(10));
        assertThat(it.hasNext(), is(true));
        assertNull(it.next());
        assertThat(it.hasNext(), is(false));
        it.next();
    }
}
