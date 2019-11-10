package ru.job4j.stream;

import java.util.List;

public class Count {
    public int count(List<Integer> data) {
        int result = 0;
        result = data.stream().filter(i -> (i % 2 == 0)).map(integer -> integer * integer).reduce(0, Integer::sum);
        return result;
    }
}
