package ru.job4j.io.cmd;

public class ParserDir {
    public String parse(String srcDir, String newSrcDir) {
        String root = newSrcDir.startsWith("/") ? "/" : srcDir;
        StringBuilder stringBuilder = new StringBuilder(root);
        String str = new StringBuilder(newSrcDir).toString();
        while (str.length() != 0) {
            int pos = str.indexOf('/');
            String newSubStr = (pos != -1) ? str.substring(0, pos) : str;
            switch (newSubStr) {
                case "":
                case ".":
                    newSubStr += "/";
                    break;
                case "..":
                    int i = stringBuilder.lastIndexOf("/");
                    stringBuilder = (i == 0) ? new StringBuilder("/") : new StringBuilder(stringBuilder.substring(0, i));
                    break;
                default:
                    if (!stringBuilder.toString().equals("/")) {
                        stringBuilder.append("/");
                    }
                    stringBuilder.append(newSubStr);
                    break;
            }
            str = str.replaceFirst(newSubStr, "");
        }
        return stringBuilder.toString();
    }
}
