package ru.job4j.stragery;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TriangleTest {
    @Test
    public void whenTriangleDraw() {
        Shape shape = new Triangle();
        String result = shape.draw();
        StringBuilder expected = new StringBuilder();
        expected.append("   +\n");
        expected.append("  +++\n");
        expected.append(" +++++\n");
        expected.append("+++++++\n");
        assertThat(result, is(expected.toString()));

    }
}
