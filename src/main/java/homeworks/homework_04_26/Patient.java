package homeworks.homework_04_26;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@ToString
public class Patient implements Comparable<Patient> {
    private Integer  id;
    private String name;
    private String surname;
    private LocalDate dateOfBirth;

    @Override
    public int compareTo(Patient o) {
        int result = this.surname.compareTo(o.surname);

        if (result == 0){
            result = this.name.compareTo(o.getName());
        }

        return result;
    }
}
