package lessons.lesson_04_19;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        List<QuizItem> array = generateData();
        QuizItem question = array.get(random.nextInt(array.size()));

        System.out.println("Вопрос: " + question.getQuestionText());
        System.out.println(" ");
        System.out.println("Варианты ответов: ");
        System.out.println(" ");

        for (int i = 0; i < question.getAnswers().size(); i++) {
            System.out.println(i + ") " + question.getAnswers().get(i));
        }

        System.out.println("напишите ответ: ");
        String answer = scanner.nextLine();

        if (answer.equals(question.getRightAnswer())) {
            System.out.println("Правильно!");
        } else {
            System.out.println("неверно!");
        }
    }

    private static List<QuizItem>generateData() {
        List<QuizItem> array = new ArrayList<>();
            array.add(new QuizItem(
                    "Сколько пальцев на руке?", "5",
                    Arrays.asList(
                           "6",
                            "7",
                           "8")
            ));

        array.add(new QuizItem(
                "Из каких объектов состоит LinkedList?",
                "Node",
                Arrays.asList(
                        "List",
                        "Xerist",
                        "null")
        ));

        array.add(new QuizItem(
                "Сколько будет 2 + 2",
                "Node",
                Arrays.asList(
                        "3",
                        "5",
                        "6")
        ));
        return array;
    }
}
