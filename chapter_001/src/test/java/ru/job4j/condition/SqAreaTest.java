package ru.job4j.condition;

import org.junit.Assert;
import org.junit.Test;

public class SqAreaTest {

    @Test
    public void square() {
        int p = 6;
        int k = 2;
        double expected = Math.pow((p / (2 * k + 2)), 2) * k;
        double out = SqArea.square(6, 2);
        Assert.assertEquals(expected, out, 0.01);
    }
}
