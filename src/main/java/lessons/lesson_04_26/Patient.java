package lessons.lesson_04_26;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@ToString
public class Patient {
    private Integer  id;
    private String name;
    private String surname;
    private LocalDate dateOfBirth;
}
