package lessons.testCollection.houses_tasks;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class Box {
    private double length;
    private  double width;
    private  double height;
    private double weight;
    private Color color;

    @Override
    public String toString() {
        return "Box[" +
                "L: " + length +
                ", W: " + width +
                ", H: " + height +
                ", WEIGHT: " + weight +
                ", COLOR: " + color +
                ']';
    }
}
