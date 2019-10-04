package ru.job4j.loop;

public class Fitness {

    public int calc(int ivan, int nik) {
        int month = 0;
        if (nik < ivan) {
            return month;
        }
        while (ivan <= nik) {
            ivan *= 3;
            nik *= 2;
            ++month;
        }
        return month;
    }
}
