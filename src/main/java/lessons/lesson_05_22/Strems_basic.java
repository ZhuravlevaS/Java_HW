package lessons.lesson_05_22;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Strems_basic {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 0);
        System.out.println(filterEvenNumbers(numbers));

        List<String> strings = List.of("Ad", "GG", "a", "hh");
        System.out.println(filterStringsStartingWithA(strings));
        System.out.println(noneMatchZero(numbers));
    }

        // 1. filter()
        // Задача: Отфильтровать список чисел, оставив только четные.
        public static List<Integer> filterEvenNumbers(List<Integer> numbers) {
            return numbers.stream()
                    .filter(number -> number % 2 == 0)
                    .toList();
        }

        // 2. filter()
        // Задача: Отфильтровать список строк, оставив только те, которые начинаются с буквы "A".
        public static List<String> filterStringsStartingWithA(List<String> strings) {
            return strings.stream().filter((s -> s.startsWith("A"))).collect(Collectors.toList());
        }

        // 3. map()
        // Задача: Преобразовать список строк в список их длин.
        public List<Integer> mapToStringLengths(List<String> strings) {
            return strings.stream().map((s -> s.length())).collect(Collectors.toList());
        }

        // 4. map()
        // Задача: Преобразовать список чисел в список их квадратов.
        public List<Integer> mapToSquares(List<Integer> numbers) {
            return numbers.stream().map((number)-> (int) Math.pow(number, 2)).collect(Collectors.toList());
        }
//
//        // 5. distinct()
//        // Задача: Удалить дубликаты из списка чисел.
        public List<Integer> distinctNumbers(List<Integer> numbers) {
            return numbers.stream().distinct().collect(Collectors.toList());
        }
//
//        // 6. distinct()
//        // Задача: Удалить дубликаты строк из списка.
        public List<String> distinctStrings(List<String> strings) {
            return strings.stream()
                    .distinct()
                    .collect(Collectors.toList());
        }

//        // 7. sorted()
//        // Задача: Отсортировать список чисел по возрастанию.
        public List<Integer> sortNumbersAscending(List<Integer> numbers) {
            return numbers.stream()
                    .sorted()
                    .collect(Collectors.toList());
        }
//
//        // 8. sorted()
//        // Задача: Отсортировать список строк по алфавиту.
        public List<String> sortStringsAlphabetically(List<String> strings) {
            return strings.stream()
                    .sorted()
                    .collect(Collectors.toList());
        }
//
//        // 9. limit()
//        // Задача: Вернуть первые 5 элементов из списка чисел.
        public List<Integer> limitFirstFiveNumbers(List<Integer> numbers) {
            return numbers.stream()
                    .limit(5)
                    .collect(Collectors.toList());
        }
//
//        // 10. limit()
//        // Задача: Вернуть первые 3 строки из списка.
        public List<String> limitFirstThreeStrings(List<String> strings) {
            return strings.stream()
                    .limit(3)
                    .collect(Collectors.toList());
        }
//
//        // 11. skip()
//        // Задача: Пропустить первые 3 элемента списка чисел.
        public List<Integer> skipFirstThreeNumbers(List<Integer> numbers) {
            return numbers.stream().limit(3).collect(Collectors.toList());
        }

//        // 12. skip()
//        // Задача: Пропустить первые 2 строки из списка.
        public List<String> skipFirstTwoStrings(List<String> strings) {
            return strings.stream().skip(2).collect(Collectors.toList());
        }
//
//        // 13. forEach()
//        // Задача: Напечатать каждое число из списка.
        public void forEachPrintNumber(List<Integer> numbers) {
            numbers.stream()
                    .forEach((el)-> System.out.println(el));
        }
//
//        // 14. forEach()
//        // Задача: Напечатать каждую строку из списка.
        public void forEachPrintString(List<String> strings) {
            strings.stream()
                    .forEach((el)-> System.out.println(el));
        }
//
//        // 15. allMatch()
//        // Задача: Проверить, все ли числа в списке четные.
        public boolean allMatchEvenNumbers(List<Integer> numbers) {
           return numbers.stream().allMatch((number)-> number % 2 == 0);
        }
//
//        // 16. anyMatch()
//        // Задача: Проверить, есть ли в списке хотя бы одно отрицательное число.
        public boolean anyMatchNegativeNumber(List<Integer> numbers) {
           return numbers.stream().anyMatch((number) -> number < 0);
        }
//
//        // 17. noneMatch()
//        // Задача: Проверить, нет ли в списке нулевых значений.
        public static boolean noneMatchZero(List<Integer> numbers) {
            return numbers.stream().noneMatch((el) -> el == 0);
        }

        // 18. findFirst()
        // Задача: Найти первый элемент в списке строк.
        public Optional<String> findFirstString(List<String> strings) {
            return strings.stream().findFirst();
        }

        // 19. reduce()
        // Задача: Найти сумму всех чисел в списке.
        public int reduceSum(List<Integer> numbers) {
            return numbers.stream()
                    .reduce((acc, currentEl) -> acc + currentEl).get();
        }

        // 20. collect()
        // Задача: Собрать все строки в список, которые начинаются с буквы "B".
        public List<String> collectStringsStartingWithB(List<String> strings) {
            return strings.stream().filter((str) -> str.startsWith("B")).collect(Collectors.toList());
        }

        // 21. flatMap()
        // Задача: Преобразовать список списков чисел в один плоский список.
//        public List<Integer> flatMapLists(List<List<Integer>> listOfLists) {
//            return listOfLists.stream().flatMap();
//        }
//
//        // 22. count()
//        // Задача: Посчитать количество строк в списке, которые длиннее 3 символов.
//        public long countLongStrings(List<String> strings) {
//            // решение
//        }
//
//        // 23. max()
//        // Задача: Найти максимальное значение в списке чисел.
//        public Optional<Integer> findMaxValue(List<Integer> numbers) {
//            // решение
//        }
//
//        // 24. min()
//        // Задача: Найти минимальное значение в списке чисел.
//        public Optional<Integer> findMinValue(List<Integer> numbers) {
//            // решение
//        }

//        // 25. findAny()
//        // Задача: Найти любой элемент в списке строк, начинающийся с буквы "C".
//        public Optional<String> findAnyStringStartingWithC(List<String> strings) {
//            // решение
//        }
//
//        // 26. toArray()
//        // Задача: Преобразовать список строк в массив строк.
//        public String[] toArrayStrings(List<String> strings) {
//            // решение
//        }
//
//        // 27. peek()
//        // Задача: Вывести на экран каждое число из списка перед удвоением значения.
//        public List<Integer> peekAndDoubleNumbers(List<Integer> numbers) {
//            // решение
//        }
//
//        // 28. mapToInt()
//        // Задача: Преобразовать список строк в список их длин и найти сумму длин всех строк.
//        public int mapToIntAndSum(List<String> strings) {
//            // решение
//
//        }


}
