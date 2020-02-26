package ru.job4j.io.cmd;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class ParserDir {
    public String parse(String srcDir, String newSrcDir) {
        Deque<String> newDir = newSrcDir.startsWith("/") ? new ArrayDeque<>() : new ArrayDeque<>(Arrays.asList(srcDir.split("/")));
        String[] strs = newSrcDir.split("/");
        for (String newSubStr : strs) {
            switch (newSubStr) {
                case "":
                case ".":
                    break;
                case "..":
                    newDir.pollLast();
                    break;
                default:
                    newDir.addLast(newSubStr);
                    break;
            }
        }
        String[] s = newDir.toArray(new String[newDir.size()]);
        String result = String.join("/", s);
        return result.startsWith("/") ? result : "/" + result;
    }
}
