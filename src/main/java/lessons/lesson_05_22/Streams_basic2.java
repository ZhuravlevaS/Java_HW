package lessons.lesson_05_22;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Streams_basic2 {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 0);
        List<String> list = List.of("A", "", "B", "C");
        System.out.println(filterSortReverseAndJoin(list));
    }

    // 1. Отфильтровать четные числа, отсортировать и вернуть первые 3
    public List<Integer> filterSortLimit(List<Integer> numbers) {
        return numbers.stream()
                .filter(num -> num % 2 == 0)
                .sorted()
                .limit(3)
                .collect(Collectors.toList());
    }

    // 2. Преобразовать список строк в их длины, удалить дубликаты, отсортировать
    public Object mapDistinctSort(List<String> strings) {
        return strings.stream()
                .map((str) -> str.length())
                .distinct()
                .sorted()
                .collect(Collectors.toList());

    }

    // 3. Отфильтровать строки, начинающиеся с "A", отсортировать по длине, вернуть первые 5
    public List<String> filterSortLimitStrings(List<String> strings) {
        return strings.stream()
                .filter(str -> str.startsWith("A"))
                .sorted((str1, str2) -> str1.length() - str2.length())
                .limit(5)
                .collect(Collectors.toList());
    }

    // 4. Найти сумму квадратов всех четных чисел
    public int sumOfSquaresOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .reduce((acc, curElement) -> {
                    if (curElement % 2 == 0) {
                        acc += curElement * curElement;
                        return acc;
                    }
                    return acc;
                }).get();
    }

    // 5. Отфильтровать строки, отсортировать и вернуть как массив
    public String[] filterSortToArray(List<String> strings) {
        return  strings.stream()
                .filter((str) -> !str.isEmpty())
                .sorted()
                .toArray(String[]::new);
    }

    // 6. Преобразовать список чисел в их квадратные корни, удалить дубликаты и посчитать количество
    public long countDistinctSquareRoots(List<Integer> numbers) {
        return numbers.stream()
                .map((number) -> Math.sqrt(number))
                .distinct()
                .count();
    }

    // 7. Отфильтровать строки, отсортировать в обратном порядке и соединить в одну строку
    public static String filterSortReverseAndJoin(List<String> strings) {
        return strings.stream()
                .filter((str) -> !str.isEmpty())
                .sorted((str1, str2) -> str2.compareTo(str1))
                .collect(Collectors.joining());
    }

    // 8. Отфильтровать нечетные числа, удвоить, отсортировать и вернуть как список
    public List<Integer> filterDoubleSort(List<Integer> numbers) {
        return numbers.stream()
                .filter((num) -> num % 2 != 0)
                .map((num) -> num * 2)
                .sorted()
                .collect(Collectors.toList());
    }

    // 9. Преобразовать список строк в список их длин, отфильтровать длины больше 3 и найти максимум
    public Optional<Integer> maxLengthGreaterThanThree(List<String> strings) {
        return strings.stream()
                .map((str) -> str.length())
                .filter((num) -> num > 3)
                .max((num1, num2) -> num1 - num2);
    }

    // 10. Отфильтровать строки, не начинающиеся с "A", отсортировать по алфавиту и вернуть первые 3
    public List<String> filterNotStartingWithASortLimit(List<String> strings) {
        return strings.stream()
                .filter((str) -> !str.startsWith("A"))
                .sorted()
                .limit(3)
                .collect(Collectors.toList());
    }

    // 11. Преобразовать список чисел в строки, удалить дубликаты, отсортировать и соединить через запятую
    public String mapDistinctSortAndJoin(List<Integer> numbers) {
        return numbers.stream()
                .map(num -> Integer.toString(num))
                .distinct()
                .sorted()
                .collect(Collectors.joining(", "));
    }

    // 12. Отфильтровать числа больше 10, удвоить их, посчитать количество уникальных
    public long countDistinctDoubledGreaterThanTen(List<Integer> numbers) {
        return numbers.stream()
                .filter((num) -> num > 10)
                .map(num -> num * 2)
                .distinct()
                .count();
    }

    // 13. Преобразовать строки в верхний регистр, удалить дубликаты, отсортировать и вернуть как список
    public List<String> toUpperCaseDistinctSort(List<String> strings) {
        return strings.stream()
                .map(str -> str.toUpperCase())
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }

    // 14. Отфильтровать строки, длина которых больше 5, отсортировать по длине и найти первую
    public Optional<String> findFirstLongStringSorted(List<String> strings) {
        return strings.stream()
                .filter((str) -> str.length() > 5)
                .sorted(Comparator.comparingInt(String::length))
                .findFirst();
    }

    // 15. Преобразовать список чисел в их квадраты, отфильтровать те, что меньше 50, и найти минимум
    public Optional<Integer> minSquareLessThanFifty(List<Integer> numbers) {
        return numbers.stream()
                .map(num -> num * num)
                .filter(num -> num < 50)
                .min(Integer::compareTo);
    }

    // 16. Отфильтровать строки, начинающиеся с "B", отсортировать и посчитать количество
    public long countStartingWithBSorted(List<String> strings) {
        return strings.stream()
                .filter(str -> str.startsWith("B"))
                .sorted()
                .count();
    }

    // 17. Преобразовать числа в их строки, удалить дубликаты, отсортировать и найти любую строку
    public Optional<String> findAnyDistinctSortedString(List<Integer> numbers) {
        return numbers.stream()
                .map(num -> Integer.toString(num))
                .distinct()
                .sorted()
                .findAny();
    }

    // 18. Отфильтровать строки длиной больше 3, преобразовать в верхний регистр и вернуть как массив
    public String[] filterLengthGreaterThanThreeToUpperArray(List<String> strings) {
        return strings.stream()
                .filter(str -> str.length() > 3)
                .map(String::toUpperCase)
                .toArray(String[]::new);
    }

    // 19. Отфильтровать числа больше 5, преобразовать в их кубы и вернуть как список
    public List<Integer> filterGreaterThanFiveMapToCubes(List<Integer> numbers) {
        return numbers.stream()
                .filter(num -> num > 5)
                .map(num -> (int) Math.pow(num, 3))
                .collect(Collectors.toList());
    }

    // 20. Преобразовать строки в их длины, отфильтровать четные, отсортировать и вернуть как список
    public List<Integer> mapToLengthsFilterEvenSort(List<String> strings) {
        return strings.stream()
                .map(str -> str.length())
                .filter(num -> num % 2 == 0)
                .sorted()
                .collect(Collectors.toList());
    }

    // 21. Отфильтровать строки, начинающиеся с "C", отсортировать, пропустить первые 2 и вернуть остальные
    public List<String> filterStartingWithCSkipFirstTwo(List<String> strings) {
        return strings.stream().filter(str -> str.startsWith("C"))
                .sorted()
                .skip(2)
                .collect(Collectors.toList());
    }

    // 22. Преобразовать числа в строки, удалить дубликаты, отсортировать по длине и вернуть как список
    public List<String> mapToStringDistinctSortByLength(List<Integer> numbers) {
        return numbers.stream()
                .map(num -> Integer.toString(num))
                .distinct()
                .sorted((num1, num2) -> num1.compareTo(num2))
                .collect(Collectors.toList());
    }

    // 23. Отфильтровать строки, длина которых больше 2, отсортировать и посчитать количество уникальных
    public long countDistinctLengthGreaterThanTwo(List<String> strings) {
        return strings.stream()
                .filter(s -> s.length() > 2)
                .sorted()
                .distinct()
                .count();
    }

    // 24. Преобразовать строки в нижний регистр, удалить дубликаты, отсортировать и вернуть как список
    public List<String> toLowerCaseDistinctSort(List<String> strings) {
        return strings.stream()
                .map(s -> s.toLowerCase())
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }

    // 25. Отфильтровать строки, начинающиеся с "D", преобразовать в их длины, удалить дубликаты и вернуть как список
    public List<Integer> filterStartingWithDMapToLengthsDistinct(List<String> strings) {
        return strings.stream()
                .filter(s -> s.startsWith("D"))
                .map(s -> s.length())
                .distinct()
                .collect(Collectors.toList());
    }
}
