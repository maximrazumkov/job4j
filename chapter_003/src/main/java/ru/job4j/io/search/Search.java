package ru.job4j.io.search;

import java.util.List;
import java.util.function.Consumer;

public class Search {
    private final Parser parser;
    private final Searcher searcher;
    private final Out out;
    private final Consumer<String> print;

    public Search(Parser parser, Searcher searcher, Out out, Consumer<String> print) {
        this.parser = parser;
        this.searcher = searcher;
        this.out = out;
        this.print = print;
    }

    public static void main(String[] args) {
        Parser parser = new SimpleParser(args, new SimpleFactory());
        Searcher searcher = new SearcherBase();
        Out out = new SimpleOut();
        new Search(parser, searcher, out, System.out::println).run();
    }

    public void run() {
        boolean res = true;
        if (!parser.parse()) {
            res = false;
            print.accept(parser.getMessage());
        }
        if (res) {
            Params params = parser.getResult();
            List<String> result = searcher.searchAllFiles(params.getDir(), params.getCondition());
            out.write(params.getOut(), result);
        }
    }

}
