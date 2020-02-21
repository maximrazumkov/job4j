package ru.job4j.db.magnit.interfaces;

public interface Converter<T> {
    void convert(T value);
}
