package ru.job4j.comparator;

import org.junit.Test;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ListCompareTest {
    @Test
    public void whenStringsAreEqualThenZero () {
        ListCompare compare = new ListCompare();
        int rst = compare.compare(
                "Ivanov",
                "Ivanov"
        );
        assertThat(rst, is(0));
    }

    @Test
    public void whenLeftLessThanRightResultShouldBeNegative () {
        ListCompare compare = new ListCompare();
        int rst = compare.compare(
                "Ivanov",
                "Ivanova"
        );
        assertThat(rst, lessThan(0));
    }

    @Test
    public void whenLeftGreaterThanRightResultShouldBePositive () {
        ListCompare compare = new ListCompare();
        int rst = compare.compare(
                "Petrov",
                "Ivanova"
        );
        assertThat(rst, greaterThan(0));
    }

    @Test
    public void secondCharOfLeftGreaterThanRightShouldBePositive(){
        ListCompare compare = new ListCompare();
        int rst = compare.compare(
                "Petrov",
                "Patrov"
        );
        assertThat(rst, greaterThan(0));
    }

    @Test
    public void secondCharOfLeftLessThanRightShouldBeNegative(){
        ListCompare compare = new ListCompare();
        int rst = compare.compare(
                "Patrova",
                "Petrov"
        );
        assertThat(rst, lessThan(0));
    }

    @Test
    public void whenStringsIsEmpty(){
        ListCompare compare = new ListCompare();
        int rst = compare.compare(
                "",
                ""
        );
        assertThat(rst, is(0));
    }

    @Test
    public void whenRightStringIsEmpty(){
        ListCompare compare = new ListCompare();
        int rst = compare.compare(
                "Patrova",
                ""
        );
        assertThat(rst, greaterThan(0));
    }

    @Test
    public void whenLeftStringIsEmpty(){
        ListCompare compare = new ListCompare();
        int rst = compare.compare(
                "",
                "Patrova"
        );
        assertThat(rst, lessThan(0));
    }
}
