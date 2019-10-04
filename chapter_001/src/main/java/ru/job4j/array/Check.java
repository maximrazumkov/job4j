package ru.job4j.array;

public class Check {
    public boolean mono(boolean[] data) {
        if (data.length == 0) {
            return true;
        }

        boolean result = data[0];
        for (int i = 0; i < data.length; ++i) {
            if (result != data[i]) {
                return false;
            }
        }
        return true;
    }
}
