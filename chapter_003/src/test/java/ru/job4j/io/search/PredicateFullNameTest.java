package ru.job4j.io.search;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PredicateFullNameTest {
    private PredicateFullName predicateFullName;

    @Before
    public void intiPredicate() {
        predicateFullName = new PredicateFullName("test.txt");
    }

    @Test
    public void whenStringsEquals() {
        boolean result = predicateFullName.test("test.txt");
        assertThat(result, is(true));
    }

    @Test
    public void whenStringsNotEquals() {
        boolean result = predicateFullName.test("notTest.txt");
        assertThat(result, is(false));
    }
}
