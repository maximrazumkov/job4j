package ru.job4j.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MatrixToListTest {
    @Test
    public void whenMatrixToList() {
        Integer[][] arr = {{1, 2}, {3, 4}, {5, 6}, {7, 8}};
        List<Integer> expect = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        MatrixToList matrixToList = new MatrixToList();
        List<Integer> result = matrixToList.matrixToList(arr);
        assertThat(result, is(expect));
    }
}
