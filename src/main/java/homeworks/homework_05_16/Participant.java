package homeworks.homework_05_16;

import homeworks.homework_05_16.exceptions.EmptyNameException;
import lombok.Getter;
import lombok.ToString;
import messages.ErrorMessages;

@Getter
@ToString
public class Participant {
    private String name;
    private int age;


    public Participant(String name, int age) {
        if (name.isEmpty() || name == null) {
            throw new EmptyNameException(ErrorMessages.NAME_EMPTY_EXCEPTION);
        } else {
            this.name = name;
            this.age = age;
        }

    }
}



