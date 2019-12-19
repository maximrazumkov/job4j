package ru.job4j.collection.map;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class UserUtil {
    public static void main(String[] args) {
        Map<Usr, Object> users = new HashMap<>();
        Calendar cal = Calendar.getInstance();
        Usr user1 = new Usr("Jon", 18, cal);
        Usr user2 = new Usr("Jon", 18, cal);
        users.put(user1, new Object());
        users.put(user2, new Object());
        System.out.println(users);
    }
}
