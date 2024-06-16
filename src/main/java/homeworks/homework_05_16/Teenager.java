package homeworks.homework_05_16;

import homeworks.homework_05_16.exceptions.AgeBoundException;
import lombok.Getter;
import lombok.ToString;
import messages.ErrorMessages;

@Getter
@ToString
public class Teenager extends Participant {
    public Teenager(String name, int age) {
        super(name, validateAge(age));
    }

    private static int validateAge(int age) {
        if(age < 10 || age > 21) {
            throw new AgeBoundException(ErrorMessages.AGE_BOUNDARY_EXCEPTION + "between 9 and 21");
        }
        return age;
    }
}
