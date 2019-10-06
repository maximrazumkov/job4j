package ru.job4j.condition;

public class Triangle {
    private Point first;
    private Point second;
    private Point third;

    public Triangle(Point ap, Point bp, Point cp) {
        this.first = ap;
        this.second = bp;
        this.third = cp;
    }

    /**
     * Метод вычисления периметра по длинам сторон.
     *
     * Формула.
     *
     * (a + b + c) / 2
     *
     * @return Периметр.
     */
    public double period() {
        double ab = this.first.distance(this.second);
        double ac = this.first.distance(this.third);
        double bc = this.second.distance(this.third);
        return (ab + ac + bc) / 2;
    }

    /**
     * Метод должен вычислить площадь треугольника.
     *
     * Формула.
     *
     * √ p *(p - ab) * (p - ac) * (p - bc)
     *
     * где √ - корень квадратный, для извлечения корня использовать метод Math.sqrt().
     *
     * @return Вернуть площадь, если треугольник существует или -1.
     */
    public double area() {
        double rsl = -1;
        double a = first.distance(second);
        double b = first.distance(third);
        double c = second.distance(third);
        double p = period();
        if (this.exist()) {
            rsl = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        }
        return rsl;
    }

    public boolean exist() {
        double ab = this.first.distance(this.second);
        double ac = this.first.distance(this.third);
        double bc = this.second.distance(this.third);
        return (ab + ac > bc) && (ab + bc > ac) && (ac + bc > ab);
    }
}
