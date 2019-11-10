package ru.job4j.sort;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class DepartureTest {

    private Departure departure;

    @Before
    public void initDeparture() {
        this.departure = new Departure();
        List<String> departures = new ArrayList<String>(Arrays.asList(
                "K1\\SK1", "K1\\SK2", "K1\\SK1\\SSK1", "K1\\SK1\\SSK2", "K2", "K2\\SK1\\SSK1", "K2\\SK1\\SSK2", "K2\\SK1", "K1"
        ));
        this.departure.setOrgs(departures);
    }

    @Test
    public void whenAbsSort() {
        List<String> expect = Arrays.asList(
                "K1", "K1\\SK1", "K1\\SK1\\SSK1", "K1\\SK1\\SSK2", "K1\\SK2", "K2", "K2\\SK1", "K2\\SK1\\SSK1", "K2\\SK1\\SSK2"
        );
        this.departure.abs();
        List<String> result = departure.getOrgs();
        assertThat(result, is(expect));
    }

    @Test
    public void whenDescSort() {
        List<String> expect = Arrays.asList(
                "K2", "K2\\SK1", "K2\\SK1\\SSK2", "K2\\SK1\\SSK1", "K1", "K1\\SK2", "K1\\SK1", "K1\\SK1\\SSK2", "K1\\SK1\\SSK1"
        );
        this.departure.desc();
        List<String> result = departure.getOrgs();
        assertThat(result, is(expect));
    }

    @Test
    public void whenFillGaps() {
        List<String> expect = Arrays.asList(
                "K1", "K1\\SK1", "K1\\SK2", "K1\\SK1\\SSK1", "K1\\SK1\\SSK2", "K2", "K2\\SK1\\SSK1", "K2\\SK1\\SSK2", "K2\\SK1", "K1"
        );
        this.departure.fillGaps(Arrays.asList("K1"));
        List<String> result = departure.getOrgs();
        assertThat(result, is(expect));
    }
}
