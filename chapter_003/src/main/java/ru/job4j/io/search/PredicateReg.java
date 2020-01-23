package ru.job4j.io.search;

import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PredicateReg implements Predicate<String> {
    private final String reg;

    public PredicateReg(String reg) {
        this.reg = reg;
    }

    @Override
    public boolean test(String s) {
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(s);
        return matcher.find();
    }
}
