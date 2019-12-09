package ru.job4j.collection.list;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SimpleQueueLIFOTest {
    private SimpleQueueLIFO<Integer> container;

    @Before
    public void initConteiner() {
        container = new SimpleQueueLIFO<>();
        container.push(1);
        container.push(2);
        container.push(3);
        container.push(4);
    }

    @Test
    public void whenPollAllElements() {
        assertThat(container.size(), is(4));
        assertThat(container.poll(), is(4));
        assertThat(container.poll(), is(3));
        assertThat(container.poll(), is(2));
        assertThat(container.poll(), is(1));
        assertThat(container.size(), is(0));
    }

    @Test
    public void whenAddNewElement() {
        assertThat(container.size(), is(4));
        container.push(10);
        assertThat(container.size(), is(5));
        assertThat(container.poll(), is(10));
        assertThat(container.size(), is(4));
    }
}
