package ru.job4j.io;

import java.io.*;

public class Analizy {
    public void unavailable(String source, String target) {
        try (BufferedReader reader = new BufferedReader(new FileReader(source));
             PrintWriter out = new PrintWriter(new FileOutputStream(target))
        ) {
            String line;
            String start = null;
            String end = null;
            while ((line = reader.readLine()) != null) {
                String time = line.substring(line.indexOf(" ") + 1);
                if (line.startsWith("500") || line.startsWith("400")) {
                    if (start == null) {
                        start = time;
                    }
                }
                if (line.startsWith("200") || line.startsWith("300")) {
                    if (start != null) {
                        end = time;
                    }
                }
                if (start != null && end != null) {
                    out.println(start + ";" + end);
                    start = null;
                    end = null;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try (PrintWriter out = new PrintWriter(new FileOutputStream("unavailable.csv"))) {
            out.println("15:01:30;15:02:32");
            out.println("15:10:30;23:12:32");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
