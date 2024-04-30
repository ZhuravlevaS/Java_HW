package lessons.lesson_17_04;

import lombok.Getter;


@Getter
public class Circle extends Figure implements FigureMethods{
    private int radius;

    public Circle(Color color, int radius) {
        super(color);
        this.radius = radius;
    }

    @Override
    public double getSquare() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimetr() {
        return 2*Math.PI*radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "color=" + super.getColor() +
                ", radius=" + radius +
                '}';
    }
}
