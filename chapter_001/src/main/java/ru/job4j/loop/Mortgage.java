package ru.job4j.loop;

public class Mortgage {
    public int year(int amount, int salary, double percent) {
        int year = 0;
        double perc = percent / 100;
        double remainig = amount;
        while (remainig > 0) {
            double accrued = remainig * perc;
            remainig = remainig + accrued - salary;
            ++year;
        }
        return year;
    }
}
