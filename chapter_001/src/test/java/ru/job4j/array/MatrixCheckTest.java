package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MatrixCheckTest {
    @Test
    public void whenDataMonoByTrueThenTrue() {
        char[][] input = {
                {' ', ' ', 'X', ' ', ' '},
                {' ', ' ', 'X', ' ', ' '},
                {' ', ' ', 'X', ' ', ' '},
                {' ', ' ', 'X', ' ', ' '},
                {' ', ' ', 'X', ' ', ' '},
        };
        boolean result = MatrixCheck.isWith(input);
        assertThat(result, is(true));
    }

    @Test
    public void whenDataNotMonoByTrueThenFalse() {
        char[][] input = {
                {' ', ' ', 'X', ' ', ' '},
                {' ', ' ', 'X', ' ', ' '},
                {' ', 'X', ' ', ' ', ' '},
                {' ', ' ', 'X', ' ', ' '},
                {' ', ' ', 'X', ' ', ' '},
        };
        boolean result = MatrixCheck.isWith(input);
        assertThat(result, is(false));
    }

    @Test
    public void whenDataMonoFirstColumnByTrueThenTrue() {
        char[][] input = {
                {'X', ' ', ' ', ' ', ' '},
                {'X', ' ', ' ', ' ', ' '},
                {'X', ' ', ' ', ' ', ' '},
                {'X', ' ', ' ', ' ', ' '},
                {'X', ' ', ' ', ' ', ' '},
        };
        boolean result = MatrixCheck.isWith(input);
        assertThat(result, is(true));
    }

    @Test
    public void whenDataMonoFirstRowByTrueThenTrue() {
        char[][] input = {
                {'X', 'X', 'X', 'X', 'X'},
                {'X', ' ', 'X', ' ', ' '},
                {'X', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' '},
        };
        boolean result = MatrixCheck.isWith(input);
        assertThat(result, is(true));
    }
}

