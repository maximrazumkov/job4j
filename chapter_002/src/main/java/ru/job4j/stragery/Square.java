package ru.job4j.stragery;

public class Square implements Shape {
    @Override
    public String draw() {
        StringBuilder pic = new StringBuilder();
        pic.append("++++\n");
        pic.append("+  +\n");
        pic.append("+  +\n");
        pic.append("++++\n");
        return pic.toString();
    }
}
