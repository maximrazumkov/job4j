package ru.job4j.io.search;

import java.util.function.Predicate;

public interface FactoryPredicate<T> {
    Predicate<T> getPredicate(String type, T template);
}
