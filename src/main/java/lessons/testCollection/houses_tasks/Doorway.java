package lessons.testCollection.houses_tasks;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Doorway {
    private double length;
    private double height;

    @Override
    public String toString() {
        return "Doorway[" +
                " L: " + length +
                ", H: " + height +
                ']';
    }
}
