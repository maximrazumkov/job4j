package ru.job4j.io.search;

public interface Parser {
    boolean parse();
    String getMessage();
    <T extends Object> T getResult();
}
