package ru.job4j.io.socket;

import java.util.Scanner;

public class ScannerInput implements Input {
     private Scanner scanner = new Scanner(System.in);

    @Override
    public String ask() {
        return scanner.nextLine();
    }
}
