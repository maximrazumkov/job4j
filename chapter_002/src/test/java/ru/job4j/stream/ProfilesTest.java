package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ProfilesTest {
    @Test
    public void whenReturnAddressList() {
        Profiles profiles = new Profiles();
        List<Address> expect = new ArrayList<>();
        List<Profile> profileList = new ArrayList<>();
        for (int i = 0; i < 10; ++i) {
            Address address = new Address("Moscow", "Chengarsky Bulvar", i, i + 10);
            expect.add(address);
            profileList.add(new Profile(address));
        }
        List<Address> result = profiles.collect(profileList);
        assertThat(result, is(expect));
    }
}
