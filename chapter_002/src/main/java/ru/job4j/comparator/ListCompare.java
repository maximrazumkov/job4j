package ru.job4j.comparator;

import java.util.Comparator;

public class ListCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int result = 0;
        int size = Math.min(left.length(), right.length());
        for (int i = 0; (i < size) && (result == 0); ++i) {
            char leftSimbol = left.charAt(i);
            char rightSimbol = right.charAt(i);
            result = Character.compare(leftSimbol, rightSimbol);
        }
        if (result == 0) {
            result = Integer.compare(left.length(), right.length());
        }
        return result;
    }
}
