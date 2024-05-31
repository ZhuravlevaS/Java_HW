package lessons._05_17_summery;


import java.io.IOException;
import java.nio.file.Path;
import java.time.*;
import java.util.Scanner;

//Напишите программу, чтобы узнать, какое исключение будет брошено, если:
//1 Распознать строку “12c” в число.
//2 Создать массив из отрицательного количества элементов.
//3 Обратиться к элементу массива, которого нет в массиве.
//4 Использовать метод valueOf() у одного из Enum, передав в него пустую строку.
//5 Создать строковую переменную, не присваивая ей значения, и вызвать у неё метод получения длины.
//6 В отдельном методе создать Scanner и указать в нём путь к файлу вместо System.in.
public class Main {
    public static void main(String[] args) throws IOException {
        // 1 Распознать строку “12c” в число.
        // getStrToInt();
        // 2 Создать массив из отрицательного количества элементов.
        // getMinusArray();
        // 3 Обратиться к элементу массива, которого нет в массиве.
        // getElementOutBoundary();
        // 4 Использовать метод valueOf() у одного из Enum, передав в него пустую строку.
        // getEmptyEnum();

        // 5 Создать строковую переменную, не присваивая ей значения, и вызвать у неё метод получения длины.
        // getLengthStr();

        // 6 В отдельном методе создать Scanner и указать в нём путь к файлу вместо System.in.

        // getScanner();

        String str = "Some";
        System.out.println(getStr(str));
        System.out.println(str);

        LocalDate ld = LocalDate.of(2023, 11, 1);
        LocalTime lt1 = LocalTime.of(10, 30);
        LocalTime lt2 = LocalTime.of(12, 45);

        Duration duration = Duration.between(lt1, lt2);
        System.out.println(duration.toHours());
        System.out.println(duration.toMinutesPart());

        ZonedDateTime z = ZonedDateTime.of(LocalDateTime.now(), ZoneId.systemDefault());
    }

    private static String getStr(String s) {
        s = s + s;
        return s;
    }

    private static void getStrToInt() {
        String s = "12c";
        int test = Integer.parseInt(s);
    }

    private static void getMinusArray() {
        int[] array = new int[-3];
    }
    private static void getElementOutBoundary() {
        int[] array = {1, 2, 3, 4,5};
        int i = array[10];
    }

    private static void getEmptyEnum() {
        DayOfWeek.valueOf("");
    }

    private static void getLengthStr() {
        String str = null;
        str.length();
    }

    private static void getScanner() throws IOException {
        Scanner scanner = new Scanner(Path.of("/genTech"));
    }
}
