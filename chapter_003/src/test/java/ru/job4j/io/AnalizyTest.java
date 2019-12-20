package ru.job4j.io;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class AnalizyTest {
    @Test
    public void whenServerWithErrors() {
        Analizy analizy = new Analizy();
        analizy.unavailable("./data/serverWithErrors.txt", "./data/unavailableWithErrors.csv");
        try (BufferedReader read = new BufferedReader(new FileReader("./data/unavailableWithErrors.csv"))) {
            String line = read.readLine();
            assertThat(line, is("10:57:01;10:59:01"));
            line = read.readLine();
            assertThat(line, is("11:01:02;11:02:02"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void whenServerWithoutErrors() {
        Analizy analizy = new Analizy();
        analizy.unavailable("./data/serverWithoutError.txt", "./data/unavailableWithoutError.csv");
        try (BufferedReader read = new BufferedReader(new FileReader("./data/unavailableWithoutError.csv"))) {
            assertNull(read.readLine());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void whenServerWithOneError() {
        Analizy analizy = new Analizy();
        analizy.unavailable("./data/serverWithOneError.txt", "./data/unavailableWithOneError.csv");
        try (BufferedReader read = new BufferedReader(new FileReader("./data/unavailableWithOneError.csv"))) {
            String line = read.readLine();
            assertThat(line, is("10:57:01;10:58:01"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
