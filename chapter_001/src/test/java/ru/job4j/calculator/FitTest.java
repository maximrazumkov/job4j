package ru.job4j.calculator;

import org.junit.Assert;
import org.junit.Test;

public class FitTest {

    @Test
    public void manWeight() {
        double height = 190;
        double expected = (height - 100) * 1.15;
        double out = Fit.manWeight(height);
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void womanWeight() {
        double height = 170;
        double expected = (height - 110) * 1.15;
        double out = Fit.womanWeight(height);
        Assert.assertEquals(expected, out, 0.01);
    }
}
