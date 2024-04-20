package lessons.lesson_04_19;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class QuizItem {
    private String questionText;
    private String rightAnswer;
    private List<String> answers;

    public List<String> getAnswers() {
        List<String> array = new ArrayList<>();

        array.addAll(answers);
        array.add(rightAnswer);
        return answers;
    }
}
