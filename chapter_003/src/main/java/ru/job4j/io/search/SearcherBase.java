package ru.job4j.io.search;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.function.Predicate;

public class SearcherBase implements Searcher {
    @Override
    public List<String> searchAllFiles(String dir, Predicate<String> condition) {
        Queue<File> files = new LinkedList<>();
        files.offer(new File(dir));
        LinkedList<String> result = new LinkedList<>();
        while (!files.isEmpty()) {
            File file = files.poll();
            if (file.isDirectory()) {
                for (File f : file.listFiles()) {
                    files.offer(f);
                }
            } else {
                String name = file.getName();
                if (condition.test(name)) {
                    result.add(name);
                }
            }
        }
        return result;
    }
}
