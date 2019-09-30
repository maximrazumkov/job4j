package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SqMaxTest {

    @Test
    public void whenFirstMax() {
        int result = SqMax.max(9, 3, 1, 2);
        assertThat(result, is(9));
    }

    @Test
    public void whenSecondMax() {
        int result = SqMax.max(9,12,3,10);
        assertThat(result, is(12));
    }

    @Test
    public void whenThridMax() {
        int result = SqMax.max(1, 2, 5,4);
        assertThat(result, is(5));
        result = SqMax.max(9, 3, 11, 2);
        assertThat(result, is(11));
    }

    @Test
    public void whenForthMax() {
        int result = SqMax.max(1,5,2,6);
        assertThat(result, is(6));
    }

    @Test
    public void whenAllEquels() {
        int result = SqMax.max(1,1,1,1);
        assertThat(result, is(1));
    }
}
