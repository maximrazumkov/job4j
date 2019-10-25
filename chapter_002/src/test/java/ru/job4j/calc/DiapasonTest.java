package ru.job4j.calc;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class DiapasonTest {
    @Test
    public void whenLinearFunctionThenLinearResults() {
        Diapason function = new Diapason();
        List<Double> result = function.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenLinearFunctionThenSquareResults() {
        Diapason function = new Diapason();
        List<Double> result = function.diapason(5, 8, x -> x * x + 2 * x + 1);
        List<Double> expected = Arrays.asList(36D, 49D, 64D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenLinearFunctionThenLogarithmicResults() {
        Diapason function = new Diapason();
        List<Double> result = function.diapason(2, 5, Math::log);
        int size = result.size();
        for (int i = 0; i < size; ++i) {
            long num = Math.round(result.get(i) * 1000);
            result.remove(i);
            result.add(i, (double) num / 1000);
        }
        List<Double> expected = new ArrayList<>();
        long num = Math.round(Math.log(2) * 1000);
        expected.add((double) num / 1000);
        num = Math.round(Math.log(3) * 1000);
        expected.add((double) num / 1000);
        num = Math.round(Math.log(4) * 1000);
        expected.add((double) num / 1000);
        assertThat(result, is(expected));
    }
}
