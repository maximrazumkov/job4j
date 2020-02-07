package ru.job4j.io.cmd;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Shell {
    private Path path = Paths.get("/");

    public Shell cd(final String path) {
        try {
            Path newPath = Paths.get(this.path.toFile().getCanonicalPath(), path);
            this.path = Paths.get(newPath.toFile().getCanonicalPath());
        } catch (Exception e) {

        }
        return this;
    }

    public String path() {
        String result = null;
        try {
            result = path.toFile().getCanonicalPath();
        } catch (IOException e) {

        }
        return result;
    }
}
