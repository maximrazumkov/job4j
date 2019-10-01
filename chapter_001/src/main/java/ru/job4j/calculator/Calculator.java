package ru.job4j.calculator;

/**
 * Calculator
 * This calculator implements addition, multiplication, subtraction, division
 * @author m.razumkov
 */
public class Calculator {

    /**
     * Addition and print to console
     * @param first term
     * @param second term
     */
    public static void add(double first, double second) {
        double result = first + second;
        System.out.println(first + "+" + second + " = " + result);
    }

    /**
     * Division and print to console
     * @param first dividend
     * @param second divider
     */
    public static void div(double first, double second) {
        double result = first / second;
        System.out.println(first + "/" + second + " = " + result);
    }

    /**
     * Multiplication and print to console
     * @param first factor
     * @param second factor
     */
    public static void multiply(double first, double second) {
        double result = first * second;
        System.out.println(first + "*" + second + " = " + result);
    }

    /**
     * Subtraction and print to console
     * @param first minuend
     * @param second subtrahend
     */
    public static void subtract(double first, double second) {
        double result = first - second;
        System.out.println(first + "-" + second + " = " + result);
    }

    /**
     * Test calculator's methods
     * @param args command line options
     */
    public static void main(String[] args) {
        add(1, 1);
        multiply(4, 4);
        div(100, 25);
        subtract(25, 20);
    }
}
