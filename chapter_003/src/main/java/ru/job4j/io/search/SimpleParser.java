package ru.job4j.io.search;

import java.util.List;
import java.util.function.Predicate;

public class SimpleParser implements Parser {
    private final String message = "При запуске программы необходимо указать следующие параметры:";
    private String[] args;
    private Params params = new Params();
    private final FactoryPredicate<String> factory;

    public SimpleParser(String[] args, FactoryPredicate<String> factory) {
        this.args = args;
        this.factory = factory;
    }

    @Override
    public boolean parse() {
        String type = "";
        for (int i = 0; i < args.length; ++i) {
            switch (args[i]) {
                case "-d":
                    if ((i + 1) < args.length) {
                        params.setDir(args[i + 1]);
                    }
                    break;
                case "-n":
                    if ((i + 1) < args.length) {
                        params.setSearchLine(args[i + 1]);
                    }
                    break;
                case "-m":
                case "-f":
                case "-r":
                    type = args[i];
                    break;
                case "-o":
                    if ((i + 1) < args.length) {
                        params.setOut(args[i + 1]);
                    }
                    break;
                default:
            }
        }
        Predicate<String> predicate = factory.getPredicate(type, params.getSearchLine());
        params.setCondition(predicate);
        boolean result = params.isFull();
        return result;
    }

    @Override
    public String getMessage() {
        StringBuilder str = new StringBuilder(message);
        List<String> emptyParams = params.getEmptyParams();
        for (String param : emptyParams) {
            str.append(" ").append(param);
        }
        return str.toString();
    }

    @Override
    public Params getResult() {
        return params;
    }
}
