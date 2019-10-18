package ru.job4j.sort;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class MachineTest {
    @Test
    public void whenEquals() {
        Machine machine = new Machine();
        int[] expected = {};
        int[] rsl = machine.change(100, 100);
        assertThat(rsl, is(expected));
    }

    @Test
    public void when50by35() {
        Machine machine = new Machine();
        int[] expected = {10, 5};
        int[] rsl = machine.change(50, 35);
        assertThat(rsl, is(expected));
    }

    @Test
    public void when50by36() {
        Machine machine = new Machine();
        int[] expected = {10, 2, 2};
        int[] rsl = machine.change(50, 36);
        assertThat(rsl, is(expected));
    }

    @Test
    public void when50by100() {
        Machine machine = new Machine();
        int[] expected = {};
        int[] rsl = machine.change(50, 100);
        assertThat(rsl, is(expected));
    }
}
