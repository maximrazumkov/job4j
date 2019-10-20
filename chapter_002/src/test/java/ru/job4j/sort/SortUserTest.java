package ru.job4j.sort;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SortUserTest {
    @Test
    public void whenSortUsers() {
        SortUser sortUser = new SortUser();
        List<User> users = new ArrayList<>();
        users.add(new User("User1", 27));
        users.add(new User("User2", 3));
        users.add(new User("User3", 18));
        users.add(new User("User4", 24));
        List<User> result = new ArrayList<>(sortUser.sort(users));
        List<User> expect = new ArrayList<>();
        expect.add(new User("User2", 3));
        expect.add(new User("User3", 18));
        expect.add(new User("User4", 24));
        expect.add(new User("User1", 27));
        assertThat(result, is(expect));
    }
}
