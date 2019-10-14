package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TrackerSingleEnumTest {
    @Test
    public void whenOneInstance() {
        TrackerSingleEnum instance = TrackerSingleEnum.INSTANCE;
        TrackerSingleEnum anotherInstance = TrackerSingleEnum.INSTANCE;
        assertThat(anotherInstance, is(instance));
    }
}
