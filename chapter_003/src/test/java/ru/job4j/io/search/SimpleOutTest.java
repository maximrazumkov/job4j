package ru.job4j.io.search;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SimpleOutTest {
    @Test
    public void whenWriteOut2Files() {
        SimpleOut simpleOut = new SimpleOut();
        List<String> list = new LinkedList<>();
        list.add("test.java");
        list.add("test.java");
        simpleOut.write("./data/resultSearch.csv", list);
        try (BufferedReader read = new BufferedReader(new FileReader("./data/resultSearch.csv"))) {
            String line = read.readLine();
            assertThat(line, is("test.java"));
            line = read.readLine();
            assertThat(line, is("test.java"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
