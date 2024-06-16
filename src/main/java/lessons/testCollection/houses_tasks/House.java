package lessons.testCollection.houses_tasks;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@ToString
@Getter
@Setter
@AllArgsConstructor
public class House {

    private List<Flat> flats;
    private int entrance;
    private boolean hasElevator;
    private int maxFloor;
}
