package lessons.lesson_17_04;

import lombok.Getter;


@Getter
public class Triangle extends Figure {
    private int side1;
    private int side2;
    private int side3;

    public double getSquare() {
        double p = (double) (side1 + side2 + side3) / 2;

        return Math.sqrt(p*(p-side1)*(p-side2)*(p-side3));
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "color=" + super.getColor() +
                ", side1=" + side1 +
                ", side2=" + side2 +
                ", side3=" + side3 +
                '}';
    }

    public Triangle(Color color, int side1, int side2, int side3) {
        super(color);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }
}
