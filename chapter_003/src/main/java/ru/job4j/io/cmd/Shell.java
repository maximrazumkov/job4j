package ru.job4j.io.cmd;

public class Shell {
    private String dir = new String("/");
    private ParserDir parserDir = new ParserDir();

    public Shell cd(final String path) {
        dir = parserDir.parse(dir, path);
        return this;
    }

    public String path() {
        return dir.toString();
    }
}
