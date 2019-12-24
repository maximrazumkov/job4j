package ru.job4j.io;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Args {

    private final String[] args;

    public Args(String[] args) {
        this.args = args;
    }

    public String directory() {
        String dir = args[1];
        return dir;
    }

    public List<File> exclude() {
        String excludeExt = args[3].substring(args[3].lastIndexOf(".") + 1);
        Queue<File> files = new LinkedList<>();
        files.offer(new File(args[1]));
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
                if (!excludeExt.equals(ext)) {
                    result.add(file);
                }
            }
        }
        return result;
    }

    public String output() {
        String target = args[5];
        return target;
    }
}
