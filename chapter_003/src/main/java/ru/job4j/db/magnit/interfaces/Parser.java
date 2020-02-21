package ru.job4j.db.magnit.interfaces;

public interface Parser<T, R> {
    R parse(T value);
}
