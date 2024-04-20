package lessons.lesson_04_19;

import java.util.ArrayList;
import java.util.List;

public class EmailDetected {
    public static void main(String[] args) {
        List<String> array = List.of("mail@mai.test", "test", "test@test.test", "ajsdhkjahd");
        System.out.println(getEmails(array));
    }

    private static List<String> getEmails(List<String> array) {
        List<String> emails = new ArrayList<>();

        for (String string: array) {
            if(string.contains("@")) {
                emails.add(string);
            }
        }

        return emails;
    }
}
