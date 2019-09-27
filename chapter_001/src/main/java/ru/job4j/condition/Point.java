package ru.job4j.condition;

public class Point {

    public static double distance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    public static void main(String[] args) {
        double result = distance(0, 0, 2, 0);
        System.out.println("result (0, 0) to (2, 0) " + result);

        result = distance(5, 6, -2, 1);
        System.out.println("result (5, 6) to (-2, 1) " + result);

        result = distance(-7, -1, 10, 15);
        System.out.println("result (-7, -1) to (10, 15) " + result);

        result = distance(8, 7, 2, -7);
        System.out.println("result (8, 7) to (2, -7) " + result);
    }
}
