package homeworks.streams;


import java.util.*;
import java.util.stream.Collectors;

public class Tasks3 {

    public static void main(String[] args) {
        m1("y");
        m2(3);
        m3();
        m4();

        String s  =  null;
    }

    /**
     * Дан список строк. Необходимо найти количество строк, которые содержат
     * заданное подстроку. Решение с использованием Stream API:
     */
    private static void m1(String substring) {

        List<String> list = Arrays.asList("Java", "JavaScript", "Python", "Ruby");

        long count = list.stream()
                .filter(str -> str.contains(substring))
                .count();

        System.out.println("Количество строк, содержащих подстроку '" + substring + "': " + count);
    }


    /**
     * Дан список целых чисел. Необходимо найти максимальный
     * элемент списка, который делится на заданное число без остатка.
     * Решение с использованием Stream API:
     */
    private static void m2(int divider) {
        List<Integer> list = Arrays.asList(10, 15, 20, 25, 33, 7);

        Optional<Integer> num = list.stream()
                .filter(number -> number % divider == 0)
                .max(Integer::compareTo);

        if (num.isPresent()) {
            System.out.println(num.get());
        } else {
            System.out.println("No such number with divider " + divider);
        }


    }


    /**
     * Дана коллекция объектов класса Person. Класс Person содержит поля name и age.
     * Необходимо найти средний возраст людей, чьи имена начинаются на заданную букву.
     * Решение с использованием Stream API:
     */
    private static void m3() {
        List<Person> people = Arrays.asList(
                new Person("John", 20),
                new Person("Mane", 25),
                new Person("Jack", 30),
                new Person("Sames", 35),
                new Person("Jill", 40),
                new Person("Sill", 44),
                new Person("rill", 48)
        );

        double av = people.stream()
                .filter(person -> person.getName().startsWith("J"))
                .mapToInt(Person::getAge)
                .average().getAsDouble();

        System.out.println(av);


    }


    /**
     * Дана коллекция строк. Необходимо найти все уникальные слова, которые содержатся в
     * этой коллекции строк, и вернуть их в виде списка. Решение с использованием Stream API:
     */
    private static void m4() {
        List<String> lines = Arrays.asList(
                "Java is a programming language.",
                "Java is widely used in enterprise applications.",
                "Python is gaining popularity as a data science tool.",
                "Python is a versatile programming language."
        );

        List<String> unique = lines.stream()
                .map(s -> s.split(" "))
                .flatMap(Arrays::stream)
                .collect(Collectors.groupingBy(
                        w -> w, LinkedHashMap::new, Collectors.counting()
                ))
                .entrySet()
                .stream()
                .filter(e -> 1L == e.getValue())
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        System.out.println(unique);
    }
}
