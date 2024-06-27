package homeworks.homework_05_16;

import homeworks.homework_05_16.exceptions.AgeBoundException;
import lombok.Getter;
import messages.ErrorMessages;

@Getter
public class Adult extends Participant {
    public Adult(String name, int age) {
        super(name, validateAge(age));
    }

    private static int validateAge(int age) {
        if(age < 21) {
            throw new AgeBoundException(ErrorMessages.AGE_BOUNDARY_EXCEPTION + "more 21.");
        }
        return age;
    }
}
