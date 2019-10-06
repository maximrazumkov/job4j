package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MaxTest {
    @Test
    public void whenMax1To2Then2() {
        int result = Max.max(1, 2);
        assertThat(result, is(2));
    }

    @Test
    public void whenMax3To2Then3() {
        int result = Max.max(3, 2);
        assertThat(result, is(3));
    }

    @Test
    public void whenMax3To3Then3() {
        int result = Max.max(3, 3);
        assertThat(result, is(3));
    }

    @Test
    public void whenFirstMax() {
        Max max = new Max();
        int result = max.max(4, 2, 3);
        assertThat(result, is(4));
    }

    @Test
    public void whenSecondMax() {
        Max max = new Max();
        int result = max.max(9, 12, 7);
        assertThat(result, is(12));
    }

    @Test
    public void whenThridMax() {
        Max max = new Max();
        int result = max.max(7, 2, 9);
        assertThat(result, is(9));
    }

    @Test
    public void whenAllEquels() {
        Max max = new Max();
        int result = max.max(1, 1, 1);
        assertThat(result, is(1));
    }
}
