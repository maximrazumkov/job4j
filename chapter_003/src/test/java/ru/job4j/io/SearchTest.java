package ru.job4j.io;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SearchTest {

    private String dir;

    @Before
    public void init() {
        dir = System.getProperty("java.io.tmpdir");
    }

    @Test
    public void whenWithExt() {
        System.out.printf("dir");
        Search search = new Search();
        List<String> exts = new ArrayList<>();
        exts.add("tmp");
        exts.add("dll");
        List<File> files = search.files(dir, exts);
        for (File f: files) {
            String name = f.getName();
            String ext = name.substring(name.lastIndexOf(".") + 1);
            assertThat(exts.contains(ext), is(true));
        }
    }

    @Test
    public void whenWithoutExt() {
        System.out.printf("dir");
        Search search = new Search();
        List<String> exts = new ArrayList<>();
        List<File> files = search.files(dir, exts);
        assertThat(files.isEmpty(), is(true));
    }
}
