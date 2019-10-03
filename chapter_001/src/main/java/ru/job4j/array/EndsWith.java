package ru.job4j.array;

public class EndsWith {
    public static boolean endsWith(char[] word, char[] post) {
        if (word.length == 0 || word.length < post.length) {
            return false;
        }

        for (int i = 1; i <= post.length; ++i) {
            boolean bool = (word[word.length - i] != post[post.length - i]);
            if (bool) {
                return false;
            }
        }
        return true;
    }
}
