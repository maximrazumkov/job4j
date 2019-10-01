package ru.job4j.loop;

public class CheckPrimeNumber {
    public boolean check(int num) {
        if (num == 0 || num == 1) {
            return false;
        }

        for (int i = 2; i < num ; ++i) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}
