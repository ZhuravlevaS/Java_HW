package lessons.lesson_17_04;

import lombok.Getter;


@Getter
public class Circle extends Figure {
    private int radius;

    public Circle(Color color, int radius) {
        super(color);
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "color=" + super.getColor() +
                ", radius=" + radius +
                '}';
    }
}
