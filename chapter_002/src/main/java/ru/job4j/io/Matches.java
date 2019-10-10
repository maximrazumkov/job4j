package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        int count = 11;
        Scanner scanner = new Scanner(System.in);
        int step = 1;
        while (true) {
            boolean exit = false;
            int player = ((step++ % 2) != 0) ? 1 : 2;
            do {
                System.out.println(String.format("Ход %s-го игрока", player));
                System.out.println(String.format("На столе осталось %s. Сколько возьмёте спичек?", count));
                System.out.println("1 Спичка");
                System.out.println("2 Спички");
                System.out.println("3 Спички");
                int qty = Integer.valueOf(scanner.nextLine());
                if (qty > 0 && qty < 4) {
                    count -= qty;
                    break;
                }
                System.out.println(String.format("Вы выбрали %s. Нужно выбрать одну, две или три спички. Повторите ввод...", qty));
            } while (true);
            if (count < 1) {
                System.out.println(String.format("Поздравляем %s-го игрока. Вы победили!!!", player));
                do {
                    System.out.println("Желаете продолжить?");
                    System.out.println("1 Да");
                    System.out.println("2 Нет");
                    int answer = Integer.valueOf(scanner.nextLine());
                    if (answer == 2) {
                        exit = true;
                        break;
                    }
                    if (answer != 1) {
                        System.out.println("Не верный ввод. Повторите...");
                    }
                } while (true);
                if (exit) {
                    break;
                }
            }
        }
    }
}
