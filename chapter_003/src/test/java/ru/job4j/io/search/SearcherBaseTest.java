package ru.job4j.io.search;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SearcherBaseTest {
    @Rule
    public TemporaryFolder temporaryFolder = new TemporaryFolder();
    private Searcher searcher;

    @Before
    public void init() {
        try {
            temporaryFolder.newFile("lib1.dll");
            temporaryFolder.newFile("lib2.dll");
            temporaryFolder.newFile("text1.txt");
            temporaryFolder.newFile("text2.txt");
            temporaryFolder.newFile("test.java");
            temporaryFolder.newFolder("tmp");
            temporaryFolder.newFolder("img");
            temporaryFolder.newFile("tmp/temp1.tmp");
            temporaryFolder.newFile("img/test.java");
            temporaryFolder.newFile("img/img2.png");
        } catch (Exception e) {
            e.printStackTrace();
        }
        searcher = new SearcherBase();
    }

    @Test
    public void whenPredicateFullName() {
        String searchLine = "test.java";
        Predicate<String> fullName = new PredicateFullName(searchLine);
        List<String> result = searcher.searchAllFiles(temporaryFolder.getRoot().getPath(), fullName);
        List<String> expect = new LinkedList<>();
        expect.add("test.java");
        expect.add("test.java");
        assertThat(result, is(expect));
    }

    @Test
    public void whenPredicateMask() {
        String searchLine = "*.java";
        Predicate<String> fullName = new PredicateMask(searchLine);
        List<String> result = searcher.searchAllFiles(temporaryFolder.getRoot().getPath(), fullName);
        List<String> expect = new LinkedList<>();
        expect.add("test.java");
        expect.add("test.java");
        assertThat(result, is(expect));
    }

    @Test
    public void whenPredicateReg() {
        String searchLine = "(\\w*)java";
        Predicate<String> fullName = new PredicateReg(searchLine);
        List<String> result = searcher.searchAllFiles(temporaryFolder.getRoot().getPath(), fullName);
        List<String> expect = new LinkedList<>();
        expect.add("test.java");
        expect.add("test.java");
        assertThat(result, is(expect));
    }
}
