package ru.job4j.io.search;

import java.util.function.Predicate;

public class SimpleFactory implements FactoryPredicate<String> {
    @Override
    public Predicate<String> getPredicate(String type, String template) {
        Predicate<String> p = null;
        switch (type) {
            case "-m":
                p = new PredicateMask(template);
                break;
            case "-f":
                p = new PredicateFullName(template);
                break;
            case "-r":
                p = new PredicateReg(template);
                break;
            default:
                break;
        }
        return p;
    }
}
