package ru.job4j.search;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserConvertTest {
    @Test
    public void whenListUsersToMapUsers() {
        UserConvert userConvert = new UserConvert();
        List<User> userList = new LinkedList<>();
        userList.add(new User(1, "User1", "Moscow"));
        userList.add(new User(2, "User2", "Moscow"));
        userList.add(new User(3, "User3", "Moscow"));
        HashMap<Integer, User> expect = new HashMap<>();
        expect.put(1, new User(1, "User1", "Moscow"));
        expect.put(2, new User(2, "User2", "Moscow"));
        expect.put(3, new User(3, "User3", "Moscow"));
        HashMap<Integer, User> result = userConvert.process(userList);
        assertThat(result, is(expect));
    }
}
