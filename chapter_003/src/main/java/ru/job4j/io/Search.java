package ru.job4j.io;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Search {
    List<File> files(String parent, List<String> exts) {
        Queue<File> files = new LinkedList<>();
        files.offer(new File(parent));
        List<File> result = new LinkedList<>();
        while (!files.isEmpty()) {
            File file = files.poll();
            if (file.isDirectory()) {
                for (File f : file.listFiles()) {
                    files.offer(f);
                }
            } else {
                String name = file.getName();
                String ext = name.substring(name.lastIndexOf(".") + 1);
                if (exts.contains(ext)) {
                    result.add(file);
                }
            }
        }
        return result;
    }
}
