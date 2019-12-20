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
                if (!"".equals(line)) {
                    int sep = line.indexOf(" ");
                    if (sep != -1) {
                        String type = line.substring(0, sep);
                        String time = line.substring(sep + 1);
                        if (!"".equals(type) && !"".equals(time)) {
                            if (type.equals("500") || type.equals("400")) {
                                if (start == null) {
                                    start = time;
                                }
                            } else {
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
                    }
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
