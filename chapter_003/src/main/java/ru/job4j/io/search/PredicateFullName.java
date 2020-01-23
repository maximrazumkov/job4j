package ru.job4j.io.search;

import java.util.function.Predicate;

public class PredicateFullName implements Predicate<String> {
    private final String name;

    public PredicateFullName(String name) {
        this.name = name;
    }

    @Override
    public boolean test(String s) {
        return name.equalsIgnoreCase(s);
    }
}
