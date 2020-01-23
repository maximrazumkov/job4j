package ru.job4j.io.search;

import java.util.function.Predicate;

public class PredicateMask implements Predicate<String> {
    private final String mask;

    public PredicateMask(String mask) {
        this.mask = mask.replaceAll("\\*", "");
    }

    @Override
    public boolean test(String s) {
        int result = s.indexOf(mask);
        return result != -1;
    }
}
