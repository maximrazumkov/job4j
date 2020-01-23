package ru.job4j.io.search;

import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.List;

public class SimpleOut implements Out {
    @Override
    public void write(String dir, List<String> result) {
        try (PrintWriter out = new PrintWriter(new FileOutputStream(dir))) {
            result.stream().forEach(r -> out.println(r));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
