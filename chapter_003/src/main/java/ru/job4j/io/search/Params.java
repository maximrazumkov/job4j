package ru.job4j.io.search;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

public class Params {
    private String dir;
    private String searchLine;
    private Predicate<String> condition;
    private String out;

    public String getDir() {
        return dir;
    }

    public String getSearchLine() {
        return searchLine;
    }

    public Predicate<String> getCondition() {
        return condition;
    }

    public String getOut() {
        return out;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public void setSearchLine(String searchLine) {
        this.searchLine = searchLine;
    }

    public void setCondition(Predicate<String> condition) {
        this.condition = condition;
    }

    public void setOut(String out) {
        this.out = out;
    }

    public boolean isFull() {
        return (dir != null)
                && (searchLine != null)
                && (condition != null)
                && (out != null);
    }

    public List<String> getEmptyParams() {
        List<String> result = new LinkedList<>();
        if (dir == null) {
            result.add("-d");
        }
        if (searchLine == null) {
            result.add("-n");
        }
        if (out == null) {
            result.add("-o");
        }
        if (condition == null) {
            result.add("-m или -f или -r");
        }
        return result;
    }
}
