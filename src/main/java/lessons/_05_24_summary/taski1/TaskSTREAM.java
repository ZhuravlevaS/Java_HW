package lessons._05_24_summary.taski1;//package PROF.streams.streams.taski1;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

//уровень 3
public class TaskSTREAM {
    /**
     * List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
     * -- Отфильтровать нв четные и не четные
     * -- Просуммировать все числа
     * -- Получить среднее значение
     * -- Найти суммы чисел кратных 3 и 5
     * <p>
     * List<String> strings = Arrays.asList("1", "2", "3", "4", "5");
     * -- Преобразовать список строк в список чисел
     * <p>
     * <p>
     * List<String> words = Arrays.asList("apple", "banana", "apricot", "cherry", "kiwi")
     * -- Отфильтровать строки на те которые начинаются на 'a' и преобразовать из в верхний регистр
     * -- Получить список слов которые содержат только уникальные символы
     * <p>
     * class Person {
     * String name
     * int age
     * }
     * <p>
     * -- Сделать из списка объектов список имен и отфильтровать по возрасту
     */

    //Задание 1: Фильтрация списка целых чисел на нечетные числа
    private static void m1() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<Integer> oddNumbers = numbers.stream()
                .filter((num) -> num % 2 != 0).collect(Collectors.toList());
        System.out.println(oddNumbers); // [1, 3, 5, 7, 9]
    }

    //Задание 2: Преобразование списка строк в список чисел
    private static void m2() {
        List<String> strings = Arrays.asList("1", "2", "3", "4", "5");

        List<Integer> numbers = strings.stream()
                .map((str) -> Integer.parseInt(str)).collect(Collectors.toList());

        System.out.println(numbers); // [1, 2, 3, 4, 5]
    }

    //Задание 3: Суммирование списка чисел
    private static void m3() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        Integer sum = numbers.stream()
                .mapToInt(num -> num).sum();

        System.out.println(sum); // 15
    }

    //Задание 4: Определение максимального значения в списке
    private static void m4() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> max = numbers.stream().max(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        System.out.println(max.get()); // 5
    }

    //
    //Задание 5: Фильтрация списка строк на те, которые начинаются с определенной буквы и преобразование их в верхний регистр
    private static void m5() {
        List<String> words = Arrays.asList("apple", "banana", "apricot", "cherry", "kiwi");
        List<String> newStrings = words.stream()
                .filter((str) -> str.startsWith("a"))
                .map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(newStrings); // 5
    }

    //Задание 6: Получение списка уникальных слов из списка строк, длина которых больше 4 символов
    private static void m6() {
        List<String> words = Arrays.asList("apple", "banana", "apricot", "cherry", "kiwi", "cherry", "kiwi");
        List<String> result = words.stream()
                .filter(s -> s.length() > 4)
                .distinct().collect(Collectors.toList());
        System.out.println(result); // [banana, apricot, cherry]
    }

    //Задание 7:Преобразование списка объектов класса в список их имен, отсортированных по возрасту
    private static void m7() {
        List<Person> people = Arrays.asList(new Person("John", 25), new Person("Alice", 22), new Person("Bob", 30));
        List<String> names = people.stream()
                .sorted((person1, person2) -> person1.getAge() - person2.getAge())
                .map(person -> person.getName()).collect(Collectors.toList());
        System.out.println(names); // [Alice, John, Bob]
    }

    //Задание 8:Нахождение суммы чисел, кратных 3 и 5, из списка чисел
    private static void m8() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int sum = numbers.stream()
                .filter((num) -> num % 3 == 0 || num % 5 == 0)
                .mapToInt(num -> num).sum();
        System.out.println(sum); // 33 (3 + 5 + 6 + 9 + 10)
    }

    //Задание 9:Получение списка слов, содержащих только уникальные символы, из списка строк
    private static void m9() {
        List<String> words = Arrays.asList("apple", "banana", "apricot", "cherry", "kiwi");
        List<String> result = words.stream()
                .filter((str) -> str.chars().distinct().count() == str.length()).collect(Collectors.toList());
        System.out.println(result); // [kiwi, grape]
    }

    //Задание 10: Напишите метод, который принимает массив строк и подсчитывает частоту встречаемости
    // каждого символа во всех строках массива. Результат подсчета должен быть представлен в виде карты (Map),
    // где ключами являются символы, а значениями - количество их вхождений. Метод должен вывести каждый символ и его частоту на консоль.
    private static void m10(String[] strings) {
       Map<Character, Long> characterFrequency =
        Arrays.stream(strings)
                .flatMapToInt(CharSequence::chars)
                .mapToObj(el -> (char)el)
                .collect(Collectors.toMap(
                        Function.identity(),
                        (el) -> 1L,
                    (oldValue, newValue) -> oldValue + 1
                ));
        System.out.println(characterFrequency);

    }


    public static void main(String[] args) {
        m10(new String[]{"mama", "papa"});

    }
}

@AllArgsConstructor
@Getter
 class ObjectChar {
    public int value;
    public int count;
}