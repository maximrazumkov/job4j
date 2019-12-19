package ru.job4j.collection;

import java.util.*;
import java.util.stream.Collectors;

public class Analize {

    public Info diff(List<User> previous, List<User> current) {
        int deleted = 0;
        int changed = 0;
        int added = 0;
        Map<Integer, User> previousMap = previous.stream().distinct().collect(
                Collectors.toMap(
                        u -> u.id,
                        u -> u
                )
        );
        for (User currUser : current) {
            User user = previousMap.get(currUser.id);
            if (user != null) {
                if (!user.name.equals(currUser.name)) {
                    ++changed;
                }
                previousMap.remove(currUser.id);
            } else {
                ++added;
            }
        }
        deleted = previousMap.size();
        return new Info(added, changed, deleted);
    }

    public static class User implements Comparable<User> {
        int id;
        String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public int compareTo(User o) {
            return name.compareTo(o.name);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            User user = (User) o;
            return id == user.id;
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }
    }

    public static class Info {
        int added;
        int changed;
        int deleted;

        public Info(int added, int changed, int deleted) {
            this.added = added;
            this.changed = changed;
            this.deleted = deleted;
        }
    }

}
