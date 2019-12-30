package ru.job4j.io.socket;

public class MemoInput implements Input {

    private final String[] phrases;
    private int idx = 0;

    public MemoInput(String[] phrases) {
        this.phrases = phrases;
    }

    @Override
    public String ask() {
        return phrases[idx++];
    }
}
