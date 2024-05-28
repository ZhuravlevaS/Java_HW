package homeworks.streams;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

//уровень 7
public class TASKI2 {
    public static void main(String[] args) throws NoSuchFieldException {
//        List<Integer> lists = List.of(1, 2, 3);
//        System.out.println(sumOfSquaresOfOddNumbers(lists));
//
//        List<Person> people = List.of(
//                new Person("John", 12),
//                new Person("Jack", 48),
//                new Person("Linsy", 48)
//        );
//
//        System.out.println(filterByField(people, "age", 48));

        List<String> strings = List.of("kjfhsksdhf ksjdfhjksd ksjdfshdf m", "Mama mwww z");

        uniqueChars(strings);
    }

    //Напишите метод, который принимает список чисел и возвращает сумму квадратов всех нечетных чисел в списке.
    public static int sumOfSquaresOfOddNumbers(List<Integer> numbers) {
        return numbers.stream()
                .reduce(0, (acc, el) -> {
                    if (el % 2 > 0) {
                        return acc + el * el;
                    }
                    return acc;
                });
    }

    //Напишите метод, который принимает список строк и возвращает список уникальных слов, отсортированных в лексикографическом порядке.
    public static List<String> uniqueSortedWords(List<String> strings) {
        return strings.stream()
                .flatMap(s -> Arrays.stream(s.split("\\W+")))
                .collect(Collectors.toMap(
                        Function.identity(),
                        el -> 1L,
                        (oldValue, el2) -> oldValue + 1
                )).entrySet().stream()
                .filter((el) -> el.getValue() == 1L)
                .map(el -> el.getKey())
                .collect(Collectors.toList());
    }

    //Напишите метод, который принимает список объектов и возвращает новый список, содержащий
    // только объекты, у которых определенное поле имеет заданное значение.
    public static <T> List<T> filterByField(List<T> objects, String fieldName, Object value) throws NoSuchFieldException {

        return objects.stream()
                .filter(obj -> {
                    try {
                        Field field = obj.getClass().getDeclaredField(fieldName);
                        Object fieldValue = field.get(obj);
                        return value.equals(fieldValue);
                    } catch (NoSuchFieldException | IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                }).collect(Collectors.toList());

    }

    //Напишите метод, который принимает список строк и возвращает список строк, содержащих
    // только уникальные символы (т.е. символы, которые не повторяются в строке).
    public static void uniqueChars(List<String> strings) {
        List<String> strings1 = strings.stream()
                .map(el -> {
                    List<Character> chars1 = el.chars().
                            mapToObj(elem -> (char) elem)
                            .collect(Collectors.toMap(
                                    Function.identity(),
                                    elem -> 1L,
                                    (oldValue, el2) -> oldValue + 1
                            ))
                            .entrySet()
                            .stream()
                            .filter((elem) -> elem.getValue() == 1L)
                            .map(elem -> elem.getKey())
                            .collect(Collectors.toList());

                    return  chars1.stream().map(e->e.toString()).collect(Collectors.joining());

                }).collect(Collectors.toList());

        System.out.println(strings1);
    }
//    //Напишите метод, который принимает список строк и возвращает самую длинную строку в списке.
//    public static String longestString(List<String> strings) {
//
//    }
//    //Напишите метод, который принимает список объектов и
//    // возвращает среднее значение заданного числового поля всех объектов в списке.
//    public static <T> double averageFieldValue(List<T> objects, String fieldName) throws NoSuchFieldException {
//
//    }
}
