package ru.job4j.array;

public class ArrayChar {
    public static boolean startWith(char[] word, char[] pref) {

        if (word.length == 0 || word.length < pref.length) {
            return false;
        }

        for (int i = 0; i < word.length && i < pref.length; ++i) {
            if (word[i] != pref[i]) {
                return false;
            }
        }
        return true;
    }
}
