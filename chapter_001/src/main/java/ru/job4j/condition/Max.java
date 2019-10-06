package ru.job4j.condition;

public class Max {
    public static int max(int first, int second) {
        return first < second ? second : first;
    }

    public int max(int first, int second, int third) {
        MultiMax multiMax = new MultiMax();
        return multiMax.max(first, second, third);
    }
}
