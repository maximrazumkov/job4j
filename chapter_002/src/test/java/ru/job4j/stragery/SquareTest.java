package ru.job4j.stragery;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SquareTest {
    @Test
    public void whenSquareDraw() {
        Shape shape = new Square();
        String result = shape.draw();
        StringBuilder expected = new StringBuilder();
        expected.append("++++\n");
        expected.append("+  +\n");
        expected.append("+  +\n");
        expected.append("++++\n");
        assertThat(result, is(expected.toString()));

    }
}
