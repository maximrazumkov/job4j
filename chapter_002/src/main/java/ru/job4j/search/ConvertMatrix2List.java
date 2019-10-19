package ru.job4j.search;

import java.util.ArrayList;
import java.util.List;


public class ConvertMatrix2List {
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        int row = array.length;
        for (int i = 0; i < row; ++i) {
            int[] cells = array[i];
            for (int cell : cells) {
                list.add(cell);
            }
        }
        return list;
    }
}
