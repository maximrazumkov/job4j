package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TrackerSingleStaticFieldTest {
    @Test
    public void whenOneInstance() {
        TrackerSingleStaticField instance = TrackerSingleStaticField.getInstance();
        TrackerSingleStaticField anotherInstance = TrackerSingleStaticField.getInstance();
        assertThat(anotherInstance, is(instance));
    }
}
