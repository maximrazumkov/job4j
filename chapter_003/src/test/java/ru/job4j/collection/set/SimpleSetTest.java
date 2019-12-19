package ru.job4j.collection.set;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SimpleSetTest {
    private SimpleSet<String> set = new SimpleSet<>();

    @Test
    public void whenAddWithoutDuplicate() {
        assertThat(set.add("Test1"), is(true));
        assertThat(set.add("Test2"), is(true));
        assertThat(set.add("Test3"), is(true));
    }

    @Test
    public void whenAddWithDuplicate() {
        assertThat(set.add("Test1"), is(true));
        assertThat(set.add("Test1"), is(false));
        assertThat(set.add("Test1"), is(false));
    }
}
