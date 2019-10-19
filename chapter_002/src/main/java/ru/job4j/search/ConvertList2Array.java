package ru.job4j.search;

import java.util.LinkedList;
import java.util.List;

public class ConvertList2Array {
    public int[][] toArray(List<Integer> list, int rows) {
        int cells = (list.size() % rows == 0) ? list.size() / rows : list.size() / rows + 1;
        int[][] array = new int[rows][cells];
        int row = 0;
        int cell = 0;
        int size = list.size();
        for (int i = 0; row < rows; ++i) {
            int num = i < size ? list.get(i) : 0;
            array[row][cell++] = num;
            if (cell == cells) {
                cell = 0;
                ++row;
            }
        }
        return array;
    }

    public List<Integer> convert(List<int[]> list) {
        List<Integer> result = new LinkedList<>();
        list.forEach(ints -> {
            for (int i : ints) {
                result.add(i);
            }
        });
        return result;
    }
}
