package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SquareTest {
    @Test
    public void whenBound3Then149() {
        int bound = 3;
        Square square = new Square();
        int[] rst = square.calculate(bound);
        int[] expected = {1,4,9};
        assertThat(rst, is(expected));
    }

    @Test
    public void whenBound0Then0() {
        int bound = 0;
        Square square = new Square();
        int[] rst = square.calculate(bound);
        int[] expected = {};
        assertThat(rst, is(expected));
    }

    @Test
    public void whenBound1Then1() {
        int bound = 1;
        Square square = new Square();
        int[] rst = square.calculate(bound);
        int[] expected = {1};
        assertThat(rst, is(expected));
    }
}
