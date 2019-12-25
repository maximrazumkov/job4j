package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Chat {
    public static void main(String[] args) {
        String path = "chapter_003/data/phrases.txt";
        String target = "chapter_003/data/log.txt";
        List<String> phrases = new ArrayList<>();
        try (
                Scanner scanner = new Scanner(System.in);
                BufferedReader reader = new BufferedReader(new FileReader(path));
                PrintWriter out = new PrintWriter(new FileWriter(target));
        ) {
            String line = "";
            while ((line = reader.readLine()) != null) {
                phrases.add(line);
            }
            String userPhrase = "";
            boolean isAnswer = true;
            do {
                userPhrase = scanner.nextLine();
                out.println(String.format("user: %s", userPhrase));
                String chatPhrase = "";
                if (userPhrase.equalsIgnoreCase("стоп") || userPhrase.equalsIgnoreCase("закончить")) {
                    isAnswer = false;
                }
                if (userPhrase.equalsIgnoreCase("продолжить")) {
                    isAnswer = true;
                }
                if (isAnswer) {
                    int idx = new Random().nextInt(phrases.size());
                    chatPhrase = phrases.get(idx);
                    out.println(String.format("chat: %s", chatPhrase));
                    System.out.println(String.format("chat: %s", chatPhrase));
                }
            } while (!userPhrase.equalsIgnoreCase("закончить"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
