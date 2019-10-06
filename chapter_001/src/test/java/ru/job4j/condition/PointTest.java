package ru.job4j.condition;

import org.junit.Assert;
import org.junit.Test;

public class PointTest {

    @Test
    public void distance() {
        int x1 = -8;
        int y1 = 5;
        int x2 = 3;
        int y2 = -1;
        double expected = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        Point a = new Point(x1, y1);
        Point b = new Point(x2, y2);

        double out = a.distance(b);
        Assert.assertEquals(expected, out, 0.01);
    }
}
