package lessons.testCollection.houses_tasks;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Setter
@Getter
public class Room {
    private double length;
    private double width;
    private double height;
    private Doorway doorway;
    private List<Box> boxes;
    private Color color;

    @Override
    public String toString() {
        return "Room[" +
                "L: " + length +
                ", W: " + width +
                ", H: " + height +
                ", DOORWAY: " + doorway +
                ", BOXES SIZE: " + boxes.size() +
                ", COLOR: " + color +
                ']';
    }
}
