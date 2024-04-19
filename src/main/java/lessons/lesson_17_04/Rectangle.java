package lessons.lesson_17_04;


import lombok.Getter;



@Getter
public class Rectangle extends Figure {
    private int width;
    private int hight;

    public Rectangle(Color color, int width, int hight) {
        super(color);
        this.width = width;
        this.hight = hight;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "color=" + super.getColor() +
                ", width=" + width +
                ", hight=" + hight +
                '}';
    }
}
