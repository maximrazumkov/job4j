package ru.job4j.stragery;

public class Paint {
    public void draw(Shape shape) {
        System.out.printf(shape.draw());
    }

    public static void main(String[] args) {
        Paint paint = new Paint();
        paint.draw(new Triangle());
        System.out.println("");
        paint.draw(new Square());
    }
}
