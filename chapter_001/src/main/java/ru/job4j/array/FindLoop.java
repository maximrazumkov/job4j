package ru.job4j.array;

public class FindLoop {

    public int indexOf(int[] data, int el) {
        return indexOf(data, el, 0, data.length - 1);
    }

    public static int indexOf(int[] data, int el, int start, int finish) {
        int endIndex = data.length - 1 < finish ? data.length - 1 : finish;
        for (int i = start; i <= endIndex; ++i) {
            if (data[i] == el) {
                return i;
            }
        }
        return -1;
    }
}
