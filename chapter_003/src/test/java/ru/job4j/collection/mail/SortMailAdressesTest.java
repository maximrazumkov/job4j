package ru.job4j.collection.mail;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SortMailAdressesTest {
    @Test
    public void when6UserThen2() {
        Map<String, Set<String>> users = new HashMap<>();
        Set<String> user1Addresses = new HashSet<>();
        user1Addresses.add("xxx@ya.ru");
        user1Addresses.add("foo@gmail.com");
        user1Addresses.add("lol@mail.ru");
        users.put("user1", user1Addresses);
        Set<String> user2Addresses = new HashSet<>();
        user2Addresses.add("ups@pisem.net");
        user2Addresses.add("foo@gmail.com");
        users.put("user2", user2Addresses);
        Set<String> user3Addresses = new HashSet<>();
        user3Addresses.add("xyz@pisem.net");
        user3Addresses.add("vasya@pupkin.com");
        users.put("user3", user3Addresses);
        Set<String> user4Addresses = new HashSet<>();
        user4Addresses.add("ups@pisem.net");
        user4Addresses.add("aaa@bbb.ru");
        users.put("user4", user4Addresses);
        Set<String> user5Addresses = new HashSet<>();
        user5Addresses.add("xyz@pisem.net");
        users.put("user5", user5Addresses);

        Map<String, Set<String>> usersResult = new HashMap<>();
        Set<String> user1Result = new HashSet<>();
        user1Result.add("xxx@ya.ru");
        user1Result.add("foo@gmail.com");
        user1Result.add("lol@mail.ru");
        user1Result.add("ups@pisem.net");
        user1Result.add("aaa@bbb.ru");
        usersResult.put("user1", user1Result);
        Set<String> user5Result = new HashSet<>();
        user5Result.add("xyz@pisem.net");
        user5Result.add("vasya@pupkin.com");
        usersResult.put("user5", user5Result);

        Map<String, Set<String>> result = SortMailAdresses.resort(users);
        assertThat(usersResult, is(result));
    }

    @Test
    public void whenAllDifferent() {
        Map<String, Set<String>> users = new HashMap<>();
        Set<String> user1Addresses = new HashSet<>();
        user1Addresses.add("xxx@ya.ru");
        user1Addresses.add("foo@gmail.com");
        user1Addresses.add("lol@mail.ru");
        user1Addresses.add("ups@pisem.net");
        user1Addresses.add("aaa@bbb.ru");
        users.put("user1", user1Addresses);
        Set<String> user5Addresses = new HashSet<>();
        user5Addresses.add("xyz@pisem.net");
        user5Addresses.add("vasya@pupkin.com");
        users.put("user5", user5Addresses);
        Map<String, Set<String>> result = SortMailAdresses.resort(users);
        assertThat(users, is(result));
    }
}
