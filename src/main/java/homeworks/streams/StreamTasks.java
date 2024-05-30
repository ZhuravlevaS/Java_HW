package homeworks.streams;

import java.util.*;
import java.util.stream.Collectors;

public class StreamTasks {
    public static void main(String[] args) {
        // Задача 1: Фильтрация чисел больше 5 и вывод в порядке убывания
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println(filterInt1(numbers));

        // Задача 2: Преобразование строк в верхний регистр и удаление дубликатов
        List<String> words = Arrays.asList("apple", "banana", "cherry", "Apple", "Banana", "Cherry");
        System.out.println(deleteDubles(words));

        // Задача 3: Вывод квадратов чисел
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(
                nums.stream()
                        .map(num -> num * num)
                        .collect(Collectors.toList())
        );

        // Задача 4: Подсчет суммы четных чисел
        List<Integer> values = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        int number = values.stream()
                .reduce(0, (acc, el) -> {
                    if (el % 2 == 0) {
                        return acc + el;
                    }
                    return acc;
                });
        System.out.println(number);


        // Задача 5: Преобразование чисел в строки и объединение их с разделителем
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6);

        String string = integers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        System.out.println(string);


        // Задача 6: Поиск первого четного числа
        Optional<Integer> firstEven =
                integers.stream()
                        .filter(num -> num % 2 == 0)
                        .findFirst();
        System.out.println("First Even: " + firstEven.orElse(null));

        //  Задача 7: Проверка, все ли строки начинаются с буквы "A"

        boolean allStartsWithA =
                words.stream()
                        .allMatch(s -> s.startsWith("A"));
        System.out.println("All Start With A: " + allStartsWithA);

        // Задача 8: Пропуск первых 3 чисел и сумма оставшихся
        int sumAfterSkip =
                integers.stream()
                        .skip(3)
                        .reduce((acc, num) -> acc + num).get();
        System.out.println("Sum After Skip: " + sumAfterSkip);

        // Задача 9: Выбор минимального и максимального числа
        Optional<Integer> minValue = numbers.stream().min(Integer::compareTo);
        Optional<Integer> maxValue = numbers.stream().max(Integer::compareTo);
        System.out.println("Min Value: " + minValue.orElse(null));
        System.out.println("Max Value: " + maxValue.orElse(null));

        // Задача 10: Группировка слов по длине
        Map<Integer, List<String>> wordsByLength =
                words.stream()
                        .collect(Collectors.groupingBy(
                                el -> el.length()
                        ));
        System.out.println("Words By Length: " + wordsByLength);

        // Задача 11: Подсчет среднего значения чисел
        OptionalDouble average =
                integers.stream()
                        .mapToInt(num -> num).average();
        System.out.println("Average: " + average.orElse(0));

        // Задача 12: Поиск всех слов, содержащих букву "a"
        List<String> wordsWithA =
                words.stream()
                        .filter(s -> s.contains("a"))
                        .collect(Collectors.toList());
        System.out.println("Words with 'a': " + wordsWithA);

        // Задача 13: Преобразование чисел в квадрат и сортировка в обратном порядке
        List<Integer> sortedSquares = integers.stream()
                .map(el -> el * el)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        System.out.println("Sorted Squares: " + sortedSquares);

        // Задача 14: Преобразование чисел в двоичный формат и объединение в строку
        String binaryNumbers =
                integers.stream()
                        .map(el -> Integer.toBinaryString(el))
                        .peek(el -> System.out.println(el))
                        .collect(Collectors.joining());
        System.out.println("Binary String: " + binaryNumbers);

        // Задача 15: Фильтрация чисел, кратных 3, и преобразование их в строки
        List<String> numbersDivisibleByThree =
                integers.stream()
                        .filter(el -> el % 3 == 0)
                        .map(num -> Integer.toString(num)).collect(Collectors.toList());
        System.out.println("Numbers Divisible by 3: " + numbersDivisibleByThree);
    }

    // Задача 1: Фильтрация чисел больше 5 и вывод в порядке убывания
    private static List<Integer> filterInt1(List<Integer> list) {
        return list.stream()
                .filter(num -> num > 5)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

    // Задача 2: Преобразование строк в верхний регистр и удаление дубликатов
    private static List<String> deleteDubles(List<String> list) {
        return list.stream()
                .map(el -> el.toUpperCase())
                .distinct()
                .collect(Collectors.toList());
    }
}