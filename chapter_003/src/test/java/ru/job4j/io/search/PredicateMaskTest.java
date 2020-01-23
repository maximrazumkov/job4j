package ru.job4j.io.search;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PredicateMaskTest {
    private PredicateMask predicateMask;

    @Before
    public void intiPredicate() {
        predicateMask = new PredicateMask("*.txt");
    }

    @Test
    public void whenStringsEquals() {
        boolean result = predicateMask.test("test.txt");
        assertThat(result, is(true));
    }

    @Test
    public void whenStringsNotEquals() {
        boolean result = predicateMask.test("notTest.exe");
        assertThat(result, is(false));
    }
}
