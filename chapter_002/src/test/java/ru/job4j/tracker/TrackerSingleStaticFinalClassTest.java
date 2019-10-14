package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TrackerSingleStaticFinalClassTest {
    @Test
    public void whenOneInstance() {
        TrackerSingleStaticFinalClass instance = TrackerSingleStaticFinalClass.getInstance();
        TrackerSingleStaticFinalClass anotherInstance = TrackerSingleStaticFinalClass.getInstance();
        assertThat(anotherInstance, is(instance));
    }
}
