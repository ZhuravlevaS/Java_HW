package lessons.lesson_05_14;

import java.util.List;

// Создайте функциональный интерфейс Adder, который имеет один метод int add(int a, int b).
//Реализуйте этот интерфейс с использованием лямбда-выражения и вызовите метод.
//
//Создайте функциональный интерфейс StringConverter, который имеет один метод String convert(String str).
//Реализуйте его с использованием лямбда-выражения для преобразования строки в верхний регистр и вызовите метод.
//
//Создайте функциональный интерфейс NumberFilter, который имеет один метод boolean filter(int number).
//Реализуйте его с использованием лямбда-выражения для проверки, является ли число четным.
// Примените фильтр к массиву чисел и выведите только четные числа.
//
//Создайте функциональный интерфейс TriFunction, который принимает три аргумента разных типов и возвращает результат.
//Реализуйте его с использованием лямбда-выражения для объединения трех строк. Вызовите метод и выведите результат.
public class Main {
    public static void main(String[] args) {
        methodAdd((a, b)-> a + b, 3, 4);
        methodStringConverter((s) -> s.toUpperCase(), "hi");

        List<Integer> integers = List.of(1, 2, 3, 4, 5, 6, 7);

        integers.forEach((el) -> {
            if (methodNumberFilter((num) -> num % 2 == 0,el)){
                System.out.println(el);
            }
        });

        System.out.println(methodTriFunction((a, b, s)-> {
            if(a > b) {
                return s;
            }
            return "no";
        }, 1, 2, "Hi"));


    }

    private static void methodAdd(Adder adder, int a, int b) {
        System.out.println(adder.add(a, b));
    }

    private static void methodStringConverter(StringConverter stringConverter, String s) {
        System.out.println(stringConverter.convert(s));
    }

    private static boolean methodNumberFilter(NumberFilter numberFilter, int number) {
        return numberFilter.filter(number);
    }

    private static String methodTriFunction(TriFunction triFunction, int a, int b, String s) {
        return triFunction.doSmth(a, b, s);
    }
}
