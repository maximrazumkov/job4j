package ru.job4j.sort;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SortUser {
    public Set<User> sort(List<User> users) {
        return new TreeSet<>(users);

    }

    public List<User> sortNameLength(List<User> users) {
        Collections.sort(users, (user1, user2) -> {
            int result = user1.getName().length() - user2.getName().length();
            return result;
        });
        return users;
    }

    public List<User> sortByAllFields(List<User> users) {
        Collections.sort(users, (user1, user2) -> {
            int result = 0;
            result = user1.getName().compareTo(user2.getName());
            if (result == 0) {
                result = user1.getAge() - user2.getAge();
            }
            return result;
        });
        return users;
    }
}
