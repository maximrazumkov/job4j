package ru.job4j.collection.mail;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SortMailAdresses {
    public static Map<String, Set<String>> resort(Map<String, Set<String>> users) {
        Map<String, String> addresses = new HashMap<>();
        Map<String, Set<String>> newList = new HashMap<>();
        for (Map.Entry<String, Set<String>> val : users.entrySet()) {
            boolean flag = true;
            String key = val.getKey();
            for (Map.Entry<String, Set<String>> newVal : newList.entrySet()) {
                int size = newVal.getValue().size() + val.getValue().size();
                Set<String> set = new HashSet<>(val.getValue());
                set.addAll(newVal.getValue());
                if (size != set.size()) {
                    val.setValue(set);
                    key = newVal.getKey();
                }
            }
            newList.put(key, val.getValue());
        }
        return newList;
    }

    public static void main(String[] args) {
        Set<String> user1Addresses = new HashSet<>();
        user1Addresses.add("xxx@ya.ru");
        user1Addresses.add("foo@gmail.com");
        user1Addresses.add("lol@mail.ru");
        Set<String> user2Addresses = new HashSet<>();
        user2Addresses.add("ups@pisem.net");
        user2Addresses.add("foo@gmail.com");
        boolean res = user1Addresses.addAll(user2Addresses);
        System.out.println(res);
    }
}
