package ru.job4j.search;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConvertList2ArrayTest {
    @Test
    public void when7ElementsThen9() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7),
                3
        );
        int[][] expect = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 0, 0}
        };
        assertThat(result, is(expect));
    }

    @Test
    public void when9ElementsThen9() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 10),
                3
        );
        int[][] expect = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 10}
        };
        assertThat(result, is(expect));
    }
    @Test
    public void whenListArrToList() {
        ConvertList2Array list = new ConvertList2Array();
        List<int[]> param = new LinkedList<>();
        param.add(new int[]{1, 2, 5});
        param.add(new int[]{1, 2});
        param.add(new int[]{3});
        param.add(new int[]{4, 2, 5, 8});
        List<Integer> result = list.convert(param);
        List<Integer> expect = Arrays.asList(1, 2, 5, 1, 2, 3, 4, 2, 5, 8);
        assertThat(result, is(expect));
    }
}
