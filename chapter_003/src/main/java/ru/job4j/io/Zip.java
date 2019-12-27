package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {

    public void pack(List<File> sources, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (File source : sources) {
                zip.putNextEntry(new ZipEntry(source.getPath()));
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source))) {
                    int b;
                    while ((b = out.read()) != -1) {
                        zip.write(b);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<File> seekBy(String root, String ext) {
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        Args arguments = new Args(args);
        String dir = arguments.directory();
        List<File> files = arguments.exclude();
        String target = arguments.output();
        new Zip().pack(files, new File("./chapter_003/pom.zip"));
    }
}
