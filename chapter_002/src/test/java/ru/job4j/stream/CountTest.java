package ru.job4j.stream;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CountTest {
    private Count count;

    @Before
    public void countInit() {
        this.count = new Count();
    }

    @Test
    public void whenEquals0() {
        int expect = 0;
        List<Integer> integers = Arrays.asList(0);
        int result = this.count.count(integers);
        assertThat(result, is(expect));
    }

    @Test
    public void whenEquals4() {
       int expect = 4;
       List<Integer> integers = Arrays.asList(0, 1, 2, 3);
       int result = this.count.count(integers);
       assertThat(result, is(expect));
    }

    @Test
    public void whenEquals120() {
        int expect = 120;
        List<Integer> integers = Arrays.asList(0, 1, 2, 3, 4, 5, 7, 10);
        int result = this.count.count(integers);
        assertThat(result, is(expect));
    }
}
