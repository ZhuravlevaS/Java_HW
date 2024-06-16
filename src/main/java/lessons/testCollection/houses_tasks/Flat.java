package lessons.testCollection.houses_tasks;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Flat {
    private List<Room> roomList;
    private double square;
    private int flatnumber;
    private int floor;

    @Override
    public String toString() {
        return "Flat[" +
                "ROOMS: " + roomList.size() +
                ", SQUARE: " + square +
                ", FLAT NUMBER: " + flatnumber +
                ", FLOOR: " + floor +
                ']';
    }
}
