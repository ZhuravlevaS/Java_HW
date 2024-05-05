package lessons._05_03.event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;
@Getter
@AllArgsConstructor
@ToString
public class Event implements Comparable<Event> {
    private final LocalDateTime dateTime;
    private final String description;

    @Override
    public int compareTo(Event o) {
        int result = this.dateTime.compareTo(o.dateTime);
        if(result == 0){
           result = this.description.compareTo(o.description);
        }

        return result;
    }
}
