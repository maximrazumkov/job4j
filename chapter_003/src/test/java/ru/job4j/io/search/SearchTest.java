package ru.job4j.io.search;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.LinkedList;
import java.util.List;
import java.util.StringJoiner;
import java.util.function.Consumer;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SearchTest {

    @Rule
    public TemporaryFolder temporaryFolder = new TemporaryFolder();
    private static final String LN = System.getProperty("line.separator");

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
    }

    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    private final Consumer<String> output = new Consumer<String>() {
        private final PrintStream stdout = new PrintStream(out);

        @Override
        public void accept(String s) {
            stdout.println(s);
        }
    };

    @Test
    public void whenSeccessSearch() {
        String[] args = new String[7];
        args[0] = "-d";
        args[1] = temporaryFolder.getRoot().getPath();
        args[2] = "-n";
        args[3] = "(\\w*)java";
        args[4] = "-r";
        args[5] = "-o";
        args[6] = "./data/resultSearch.csv";
        Parser parser = new SimpleParser(args, new SimpleFactory());
        Searcher searcher = new SearcherBase();
        SimpleOut simpleOut = new SimpleOut();
        Search search = new Search(parser, searcher, simpleOut, output::accept);
        search.run();
        List<String> expect = new LinkedList<>();
        expect.add("test.java");
        expect.add("test.java");
        try (BufferedReader read = new BufferedReader(new FileReader("./data/resultSearch.csv"))) {
            String line = read.readLine();
            assertThat(line, is("test.java"));
            line = read.readLine();
            assertThat(line, is("test.java"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void whenParseFailSearch() {
        String[] args = new String[5];
        args[0] = "-d";
        args[1] = temporaryFolder.getRoot().getPath();
        args[2] = "-n";
        args[3] = "(\\w*)java";
        args[4] = "-o";
        Parser parser = new SimpleParser(args, new SimpleFactory());
        Searcher searcher = new SearcherBase();
        SimpleOut simpleOut = new SimpleOut();
        Search search = new Search(parser, searcher, simpleOut, output::accept);
        search.run();
        String expect = String.format("При запуске программы необходимо указать следующие параметры: -o -m или -f или -r%s", LN);
        assertThat(new String(this.out.toByteArray()), is(expect));
    }
}
