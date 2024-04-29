package lessons.lesson_04_26;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class Patient {
    private String id;
    private String name;
    private String surname;
    private String dateOfBirth;
}
