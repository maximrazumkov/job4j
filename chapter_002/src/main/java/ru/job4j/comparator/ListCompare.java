package ru.job4j.comparator;

import java.util.Comparator;

public class ListCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int result = 0;
        for (int i = 0; result == 0; ++i) {
            int leftSimbol = (i < left.length()) ? left.charAt(i) : -1;
            int rightSimbol = (i < right.length()) ? right.charAt(i) : -1;
            if ((leftSimbol == -1) && (rightSimbol == -1)) {
                break;
            }
            result = Integer.compare(leftSimbol, rightSimbol);
        }
        return result;
    }
}
