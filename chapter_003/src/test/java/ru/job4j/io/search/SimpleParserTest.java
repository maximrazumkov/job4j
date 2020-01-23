package ru.job4j.io.search;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SimpleParserTest {
    @Test
    public void whenAllParamsIsValidWithPredicateFullName() {
        String[] str = new String[7];
        str[0] = "-d";
        str[1] = "c:/dist";
        str[2] = "-n";
        str[3] = "fullName.text";
        str[4] = "-f";
        str[5] = "-o";
        str[6] = "log.txt";
        SimpleParser simpleParser = new SimpleParser(str, new SimpleFactory());
        boolean res = simpleParser.parse();
        assertThat(res, is(true));
        Params params = simpleParser.getResult();
        assertThat(params.getDir(), is("c:/dist"));
        assertThat(params.getOut(), is("log.txt"));
        assertThat(params.getSearchLine(), is("fullName.text"));
        assertThat(params.isFull(), is(true));
        assertThat(params.getEmptyParams(), is(new LinkedList<>()));
    }

    @Test
    public void whenAllParamsIsValidWithPredicateReg() {
        String[] str = new String[7];
        str[0] = "-d";
        str[1] = "c:/dist";
        str[2] = "-n";
        str[3] = "*.text";
        str[4] = "-m";
        str[5] = "-o";
        str[6] = "log.txt";
        SimpleParser simpleParser = new SimpleParser(str, new SimpleFactory());
        boolean res = simpleParser.parse();
        assertThat(res, is(true));
        Params params = simpleParser.getResult();
        assertThat(params.getDir(), is("c:/dist"));
        assertThat(params.getOut(), is("log.txt"));
        assertThat(params.getSearchLine(), is("*.text"));
        assertThat(params.isFull(), is(true));
        assertThat(params.getEmptyParams(), is(new LinkedList<>()));
    }

    @Test
    public void whenAllParamsIsValidWithPredicateMask() {
        String[] str = new String[7];
        str[0] = "-d";
        str[1] = "c:/dist";
        str[2] = "-n";
        str[3] = "(\\w*)java";
        str[4] = "-r";
        str[5] = "-o";
        str[6] = "log.txt";
        SimpleParser simpleParser = new SimpleParser(str, new SimpleFactory());
        boolean res = simpleParser.parse();
        assertThat(res, is(true));
        Params params = simpleParser.getResult();
        assertThat(params.getDir(), is("c:/dist"));
        assertThat(params.getOut(), is("log.txt"));
        assertThat(params.getSearchLine(), is("(\\w*)java"));
        assertThat(params.isFull(), is(true));
        assertThat(params.getEmptyParams(), is(new LinkedList<>()));
    }

    @Test
    public void whenOneParamsIsNotValid() {
        String[] str = new String[6];
        str[0] = "-d";
        str[1] = "c:/dist";
        str[2] = "-n";
        str[3] = "(\\w*)java";
        str[4] = "-o";
        str[5] = "log.txt";
        SimpleParser simpleParser = new SimpleParser(str, new SimpleFactory());
        boolean res = simpleParser.parse();
        assertThat(res, is(false));
        Params params = simpleParser.getResult();
        assertThat(params.isFull(), is(false));
        List<String> expect = new LinkedList<>();
        expect.add("-m или -f или -r");
        assertThat(params.getEmptyParams(), is(expect));
        assertThat(simpleParser.getMessage(), is("При запуске программы необходимо указать следующие параметры: -m или -f или -r"));
    }

    @Test
    public void whenSomeParamsIsNotValid() {
        String[] str = new String[4];
        str[0] = "-d";
        str[1] = "c:/dist";
        str[2] = "-n";
        str[3] = "(\\w*)java";
        SimpleParser simpleParser = new SimpleParser(str, new SimpleFactory());
        boolean res = simpleParser.parse();
        assertThat(res, is(false));
        Params params = simpleParser.getResult();
        assertThat(params.isFull(), is(false));
        List<String> expect = new LinkedList<>();
        expect.add("-o");
        expect.add("-m или -f или -r");
        assertThat(params.getEmptyParams(), is(expect));
        assertThat(simpleParser.getMessage(), is("При запуске программы необходимо указать следующие параметры: -o -m или -f или -r"));
    }
    @Test
    public void whenAllParamsIsNotValid() {
        String[] str = new String[0];
        SimpleParser simpleParser = new SimpleParser(str, new SimpleFactory());
        boolean res = simpleParser.parse();
        assertThat(res, is(false));
        Params params = simpleParser.getResult();
        assertThat(params.isFull(), is(false));
        List<String> expect = new LinkedList<>();
        expect.add("-d");
        expect.add("-n");
        expect.add("-o");
        expect.add("-m или -f или -r");
        assertThat(params.getEmptyParams(), is(expect));
        assertThat(simpleParser.getMessage(), is("При запуске программы необходимо указать следующие параметры: -d -n -o -m или -f или -r"));
    }
}
