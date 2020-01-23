package ru.job4j.io.search;

import java.util.List;
import java.util.function.Predicate;

public interface Searcher {
    List<String> searchAllFiles(String dir, Predicate<String> condition);
}
