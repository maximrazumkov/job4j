package ru.job4j.loop;

public class Slash {

    public static void draw(int size) {
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                boolean left = i == j ? true : false;
                boolean right = (i + j + 1) == size;
                if (left) {
                    System.out.print("0");
                } else if (right) {
                    System.out.print("0");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        draw(3);
        draw(4);
        draw(5);
    }
}
