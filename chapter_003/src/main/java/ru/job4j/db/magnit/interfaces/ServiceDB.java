package ru.job4j.db.magnit.interfaces;

import java.util.Collections;
import java.util.List;

public interface ServiceDB {
    void generate(int size);
    <T> List<T> load();
}
