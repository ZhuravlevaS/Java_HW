package homeworks.homework_05_16;

import homeworks.homework_05_16.exceptions.AgeBoundException;
import lombok.Getter;
import lombok.ToString;
import messages.ErrorMessages;

@Getter
@ToString
public class Pupil extends Participant {

    public Pupil(String name, int age) {
        super(name, validateAge(age));
    }

    private static int validateAge(int age) {
        if(age > 10) {
            throw new AgeBoundException(ErrorMessages.AGE_BOUNDARY_EXCEPTION + "less 10.");
        }
        return age;
    }
}
