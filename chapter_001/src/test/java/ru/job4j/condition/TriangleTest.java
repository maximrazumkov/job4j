package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class TriangleTest {
    @Test
    public void whenExist() {
        Point first = new Point(-8, 5);
        Point second = new Point(3, -1);
        Point third = new Point(4, 4);
        Triangle triangle = new Triangle(first, second, third);
        boolean result = triangle.exist();
        assertThat(result, is(true));
    }

    @Test
    public void whenNotExist() {
        Point first = new Point(-8, 5);
        Point second = new Point(-8, -1);
        Point third = new Point(-8, 4);
        Triangle triangle = new Triangle(first, second, third);
        boolean result = triangle.exist();
        assertThat(result, is(false));
    }

    @Test
    public void whenPeriod() {
        Point first = new Point(-8, 5);
        Point second = new Point(3, -1);
        Point third = new Point(4, 4);
        double ab = first.distance(second);
        double ac = first.distance(third);
        double bc = second.distance(third);
        double expected =  (ab + ac + bc) / 2;
        Triangle triangle = new Triangle(first, second, third);
        double result = triangle.period();
        assertEquals(result, expected, 0.001);
    }

    @Test
    public void whenAreaWhenTriangleIsExist() {
        Point first = new Point(-8, 5);
        Point second = new Point(3, -1);
        Point third = new Point(4, 4);
        double ab = first.distance(second);
        double ac = first.distance(third);
        double bc = second.distance(third);
        double p = (ab + ac + bc) / 2;
        double expected = Math.sqrt(p * (p - ab) * (p - ac) * (p - bc));
        Triangle triangle = new Triangle(first, second, third);
        double result = triangle.area();
        assertEquals(expected, result, 0.001);
    }

    @Test
    public void whenAreaWhenTriangleIsNotExist() {
        Point first = new Point(-8, 5);
        Point second = new Point(-8, -1);
        Point third = new Point(-8, 4);
        double ab = first.distance(second);
        double ac = first.distance(third);
        double bc = second.distance(third);
        double p = (ab + ac + bc) / 2;
        double expected = -1;
        Triangle triangle = new Triangle(first, second, third);
        double result = triangle.area();
        assertEquals(expected, result, 0.001);
    }
}
