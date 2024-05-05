package lessons._05_03;

import lessons._05_03.event.Event;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Создайте программу, которая работает с событиями.
// Каждое событие имеет дату и описание. Используйте интерфейс Comparable
// для сортировки событий сначала по дате, затем по алфавиту описания.
public class Main {
    public static void main(String[] args) {
        List<Event> events = new ArrayList<>();

        Event event1 = new Event(LocalDateTime.now(), "dndkjhfkh ksdjfhs fkssf sfhks");
        Event event2 = new Event(LocalDateTime.of(1964, 12, 3, 12, 30, 7), "asldkjkj kajdhkhf skfkhf");
        Event event3 = new Event(LocalDateTime.now().minusDays(1), "dddd");
        Event event4 = new Event(LocalDateTime.now().minusDays(4), "dddd");
        Event event5 = new Event(LocalDateTime.now().minusDays(5), "dddd");

        events.add(event2);
        events.add(event3);
        events.add(event1);
        events.add(event4);
        events.add(event5);

        Collections.sort(events);
        for (Event event: events){
            System.out.println(event);
        }

    }
}
