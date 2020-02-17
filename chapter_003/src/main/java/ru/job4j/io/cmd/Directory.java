package ru.job4j.io.cmd;

public class Directory {
    public static void main(String[] args) {
        /*
        final Shell shell = new Shell();
        System.out.println(shell.path().equals("C:\\"));

        shell.cd("/");
        System.out.println(shell.path().equals("C:\\"));

        shell.cd("usr/..");
        System.out.println(shell.path().equals("C:\\"));

        shell.cd("usr").cd("local");
        shell.cd("../local").cd("./");
        System.out.println(shell.path().equals("C:\\usr\\local"));

        shell.cd("..");
        System.out.println(shell.path().equals("C:\\usr"));

        shell.cd("//lib///");
        System.out.println(shell.path().equals("/lib"));

         */
        final Shell shell = new Shell();
        System.out.println(shell.path().equals("/"));

        shell.cd("/");
        System.out.println(shell.path().equals("/"));

        shell.cd("usr/..");
        System.out.println(shell.path().equals("/"));

        shell.cd("usr").cd("local");
        shell.cd("../local").cd("./");
        System.out.println(shell.path().equals("/usr/local"));

        shell.cd("..");
        System.out.println(shell.path().equals("/usr"));

        shell.cd("//lib///");
        System.out.println(shell.path().equals("/lib"));
    }
}
