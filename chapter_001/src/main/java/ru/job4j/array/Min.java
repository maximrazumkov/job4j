package ru.job4j.array;

public class Min {
    public static int findMin(int[] array) {
        return MinDiapason.findMin(array, 0, array.length - 1);
    }
}
