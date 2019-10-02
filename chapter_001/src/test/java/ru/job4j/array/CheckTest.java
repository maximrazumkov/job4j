package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CheckTest {

    @Test
    public void whenArrayWithOddAmountOfElementsDataMonoByTrueThenTrue() {
        Check check = new Check();
        boolean[] input = {true, true, true};
        boolean result = check.mono(input);
        assertThat(result, is(true));
    }

    @Test
    public void whenArrayWithOddAmountOfElementsDataNotMonoByTrueThenFalse() {
        Check check = new Check();
        boolean[] input = {true, false, true};
        boolean result = check.mono(input);
        assertThat(result, is(false));
    }

    @Test
    public void whenArrayWithEvenAmountOfElementsDataMonoByTrueThenTrue() {
        Check check = new Check();
        boolean[] input = {false, false, false, false};
        boolean result = check.mono(input);
        assertThat(result, is(true));
    }

    @Test
    public void whenArrayWithEvenAmountOfElementsDataNotMonoByTrueThenFalse() {
        Check check = new Check();
        boolean[] input = {true, false, true, false};
        boolean result = check.mono(input);
        assertThat(result, is(false));
    }

    @Test
    public void whenArrayNotElementsThenTrue() {
        Check check = new Check();
        boolean[] input = {};
        boolean result = check.mono(input);
        assertThat(result, is(true));
    }
}
