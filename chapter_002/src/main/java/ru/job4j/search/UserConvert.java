package ru.job4j.search;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserConvert {
    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> users = new HashMap<>();
        list.forEach(user -> users.put(user.getId(), user));
        return users;
    }
}
