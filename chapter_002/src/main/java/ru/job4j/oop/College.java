package ru.job4j.oop;

public class College {
    public static void main(String[] args) {
        //Тип приведения - понижающее приведение (down casting)
        Freshman freshman = new Freshman();
        Student student = freshman;
        Object obj = freshman;
    }
}
