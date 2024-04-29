package lessons.lesson_04_26;

import java.util.*;

// 1. Напишите метод, который принимает на вход строку и возвращает набор уникальных слов из этой строки.

// 2. Создайте программу для учета оценок студентов. Используйте коллекцию Map,
//где ключ - это имя студента, а значение - список его оценок. Реализуйте метод для подсчета средней оценки каждого студента.

// 3. Реализуйте метод, который принимает на вход строку и возвращает Map, где ключ - это слово, а значение - количество его повторений в строке.
public class Main {

     public static void main(String[] args) {

         Map<String, List<Double>> nameToMarks = Map.of(
                 "Tom", new ArrayList<>(),
                 "Jerry", Arrays.asList(5.0,5.0)
         );
         System.out.println(getAverageMark(nameToMarks));
         System.out.println(getUniqueWords("jdfhhdjfj kadsjhfkhsdf kdasjfhhf ff ff"));
         System.out.println(getCountWords("jdfhhdjfj kadsjhfkhsdf kdasjfhhf ff ff"));
     }

     private static Set<String> getUniqueWords(String sentence) {
         return new HashSet<>(Arrays.asList(sentence.split(" ")));
     }

    private static Map<String, Integer> getCountWords(String sentence) {
        Map<String, Integer> wordToCount = new HashMap<>();
        List<String> arrayWords = Arrays.asList(sentence.split(" "));

        for (String word: arrayWords) {
            wordToCount.put(word, wordToCount.getOrDefault(word, 0) + 1);
        }

        return wordToCount;
    }

     private static Map<String, Double> getAverageMark(Map<String, List<Double>> nameToMarks) {
        Map<String, Double> nameToAverage = new HashMap<>();
        for (Map.Entry<String, List<Double>> entry: nameToMarks.entrySet()) {
            double sum = 0;

            for (Double mark: entry.getValue()) {
                sum += mark;
            }

            Double average = !entry.getValue().isEmpty() ? sum/entry.getValue().size() : 0;
            nameToAverage.put(entry.getKey(), average);
        }
        return nameToAverage;
     }
}
