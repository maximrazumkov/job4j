package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MultiMaxTest {
    @Test
    public void whenFirstMax() {
        MultiMax multiMax = new MultiMax();
        int result = multiMax.max(4, 2, 3);
        assertThat(result, is(4));
    }

    @Test
    public void whenSecondMax() {
        MultiMax multiMax = new MultiMax();
        int result = multiMax.max(9, 12, 7);
        assertThat(result, is(12));
    }

    @Test
    public void whenThridMax() {
        MultiMax multiMax = new MultiMax();
        int result = multiMax.max(7, 2, 9);
        assertThat(result, is(9));
    }

    @Test
    public void whenAllEquels() {
        MultiMax multiMax = new MultiMax();
        int result = multiMax.max(1, 1, 1);
        assertThat(result, is(1));
    }
}
