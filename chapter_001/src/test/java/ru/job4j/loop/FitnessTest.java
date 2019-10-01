package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FitnessTest {
    @Test
    public void whenIvanGreetNik() {
        Fitness fitness = new Fitness();
        int countMouth = fitness.calc(100,95);
        assertThat(countMouth, is(0));
    }

    @Test
    public void whenIvanLessByOneNik() {
        Fitness fitness = new Fitness();
        int countMouth = fitness.calc(90, 95);
        assertThat(countMouth, is(1));
    }

    @Test
    public void whenIvanLessByFewNik() {
        Fitness fitness = new Fitness();
        int countMouth = fitness.calc(50, 90);
        assertThat(countMouth, is(2));
    }
}
