package ru.job4j.io;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SearchTest {

    @Rule
    public TemporaryFolder temporaryFolder = new TemporaryFolder();

    @Before
    public void init() {
        try {
            temporaryFolder.newFile("lib1.dll");
            temporaryFolder.newFile("lib2.dll");
            temporaryFolder.newFile("text1.txt");
            temporaryFolder.newFile("text2.txt");
            temporaryFolder.newFolder("tmp");
            temporaryFolder.newFolder("img");
            temporaryFolder.newFile("tmp/temp1.tmp");
            temporaryFolder.newFile("tmp/temp2.tmp");
            temporaryFolder.newFile("img/img1.png");
            temporaryFolder.newFile("img/img2.png");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Привет");
        }
    }

    @Test
    public void whenWithExt() {
        Search search = new Search();
        List<String> exts = new ArrayList<>();
        exts.add("tmp");
        exts.add("dll");
        List<File> files = search.files(temporaryFolder.getRoot().getPath(), exts);
        for (File f: files) {
            String name = f.getName();
            String ext = name.substring(name.lastIndexOf(".") + 1);
            assertThat(exts.contains(ext), is(true));
        }
    }

    @Test
    public void whenWithoutExt() {
        Search search = new Search();
        List<String> exts = new ArrayList<>();
        List<File> files = search.files(temporaryFolder.getRoot().getPath(), exts);
        assertThat(files.isEmpty(), is(true));
    }
}
