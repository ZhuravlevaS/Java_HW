package lessons.lesson_10_04;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Car {
    private CarBrand carBrand;
    private int doorNumber;
    private boolean isSportive;
    private int capacity;
    private double price;
    private int yearOfIssue;
    private Color color;

    @Override
    public String toString() {
        return "Car{" +
                "carBrand=" + carBrand +
                ", doorNumber=" + doorNumber +
                ", isSportive=" + isSportive +
                ", capacity=" + capacity +
                ", price=" + price +
                ", yearOfIssue=" + yearOfIssue +
                ", color=" + color +
                '}';
    }
}
