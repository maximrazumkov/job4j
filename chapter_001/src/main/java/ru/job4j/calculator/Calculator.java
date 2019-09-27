package ru.job4j.calculator;

public class Calculator {

    public static void add(double first, double second) {
        double result = first + second;
        System.out.println(first + "+" + second + " = " + result);
    }

    public static void div(double first, double second) {
        double result = first / second;
        System.out.println(first + "/" + second + " = " + result);
    }

    public static void multiply(double first, double second) {
        double result = first * second;
        System.out.println(first + "*" + second + " = " + result);
    }

    public static void subtract(double first, double second) {
        double result = first - second;
        System.out.println(first + "-" + second + " = " + result);
    }

    public static void main(String[] args) {
        add(1, 1);
        multiply(4, 4);
        div(100, 25);
        subtract(25, 20);
    }
}
