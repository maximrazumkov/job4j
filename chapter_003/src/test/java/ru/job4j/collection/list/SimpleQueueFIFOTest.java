package ru.job4j.collection.list;

import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SimpleQueueFIFOTest {
    private SimpleQueueFIFO<Integer> container;

    @Before
    public void initConteiner() {
        container = new SimpleQueueFIFO<>();
        container.push(1);
        container.push(2);
        container.push(3);
        container.push(4);
    }

    @Test
    public void whenPollAllElements() {
        assertThat(container.size(), is(4));
        assertThat(container.poll(), is(1));
        assertThat(container.poll(), is(2));
        assertThat(container.poll(), is(3));
        assertThat(container.poll(), is(4));
        assertThat(container.size(), is(0));
    }

    @Test
    public void whenAddNewElement() {
        assertThat(container.size(), is(4));
        container.push(10);
        assertThat(container.size(), is(5));
        assertThat(container.poll(), is(1));
        assertThat(container.size(), is(4));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenNoSuchElement() {
        assertThat(container.poll(), is(1));
        assertThat(container.poll(), is(2));
        assertThat(container.poll(), is(3));
        assertThat(container.poll(), is(4));
        container.poll();
    }
}
