package ru.job4j.io.search;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PredicateRegTest {
    private PredicateReg predicateReg;

    @Before
    public void intiPredicate() {
        predicateReg = new PredicateReg("(\\w*)java");
    }

    @Test
    public void whenStringsEquals() {
        boolean result = predicateReg.test("test.java");
        assertThat(result, is(true));
    }

    @Test
    public void whenStringsNotEquals() {
        boolean result = predicateReg.test("notTest.class");
        assertThat(result, is(false));
    }
}
