package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ArrayCharTest {
    @Test
    public void whenStartWithPrefixThenTrue() {
        char[] word = {'H', 'e', 'l', 'l', 'o'};
        char[] pref = {'H', 'e'};
        boolean result = ArrayChar.startWith(word, pref);
        assertThat(result, is(true));
    }

    @Test
    public void whenNotStartWithPrefixThenFalse() {
        char[] word = {'H', 'e', 'l', 'l', 'o'};
        char[] pref = {'H', 'i'};
        boolean result = ArrayChar.startWith(word, pref);
        assertThat(result, is(false));
    }

    @Test
    public void whenWordIsEmptyThanFalse() {
        char[] word = {};
        char[] pref = {'H', 'i'};
        boolean result = ArrayChar.startWith(word, pref);
        assertThat(result, is(false));
    }

    @Test
    public void whenPrefIsEmptyThanFalse() {
        char[] word = {'H', 'e', 'l', 'l', 'o'};
        char[] pref = {};
        boolean result = ArrayChar.startWith(word, pref);
        assertThat(result, is(true));
    }

    @Test
    public void whenWordAndPrefIsEmptyThanFalse() {
        char[] word = {};
        char[] pref = {};
        boolean result = ArrayChar.startWith(word, pref);
        assertThat(result, is(true));
    }

    @Test
    public void whenPrefixLengthMoreWordLengthThanFalse() {
        char[] word = {'H', 'e', 'l', 'l', 'o'};
        char[] pref = {'H', 'e', 'l', 'l', 'o', '!'};
        boolean result = ArrayChar.startWith(word, pref);
        assertThat(result, is(false));
    }

    @Test
    public void whenPrefixLengthEquelsWordLengthThanTrue() {
        char[] word = {'H', 'e', 'l', 'l', 'o'};
        char[] pref = {'H', 'e', 'l', 'l', 'o'};
        boolean result = ArrayChar.startWith(word, pref);
        assertThat(result, is(true));
    }
}
