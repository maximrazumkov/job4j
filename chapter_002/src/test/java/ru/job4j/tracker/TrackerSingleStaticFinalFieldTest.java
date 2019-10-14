package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TrackerSingleStaticFinalFieldTest {
    @Test
    public void whenOneInstance() {
        TrackerSingleStaticFinalField instance = TrackerSingleStaticFinalField.getInstance();
        TrackerSingleStaticFinalField  anotherInstance = TrackerSingleStaticFinalField .getInstance();
        assertThat(anotherInstance, is(instance));
    }
}
