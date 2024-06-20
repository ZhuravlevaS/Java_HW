package lessons.dryKissYagni;

import lombok.Getter;


public class CircleQ {
    private double radius;

    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    public double calculateCircumference() {
        return 2 * Math.PI * radius;
    }
}

@Getter
class Circle {
    private double radius;
    private double area;
    private double circumference;

    public Circle(double radius) {
        this.radius = radius;
        area = Math.PI * radius * radius;
        circumference = 2 * Math.PI * radius;
    }
}

