package ru.job4j.sort;

import java.util.Arrays;

public class Merge {
    public int[] merge(int[] left, int[] right) {
        int[] rsl = new int[left.length + right.length];
        if (left.length == 0) {
            return right;
        }
        if (right.length == 0) {
            return left;
        }
        int indexLeft = 0;
        int indexRight = 0;
        for (int i = 0; i < rsl.length; ++i) {
            if (indexLeft == left.length) {
                rsl[i] = right[indexRight++];
                continue;
            }
            if (indexRight == right.length) {
                rsl[i] = left[indexLeft++];
                continue;
            }
            if (left[indexLeft] < right[indexRight]) {
                rsl[i] = left[indexLeft++];
            } else {
                rsl[i] = right[indexRight++];
            }
        }
        return rsl;
    }

    public static void main(String[] args) {
        Merge process = new Merge();
        int[] rsl = process.merge(
                new int[] {1, 3, 5},
                new int[] {2, 4}
                //new int[] {1, 5, 5},
                //new int[] {2, 4}
        );
        System.out.println(Arrays.toString(rsl));
    }
}
