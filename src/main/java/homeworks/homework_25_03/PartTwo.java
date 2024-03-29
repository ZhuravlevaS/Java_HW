package homeworks.homework_25_03;

import java.util.Arrays;

public class PartTwo {
    public static void main(String[] args) {
        int[] array = new int[] {0, 3, 4, 5, 7, 2, 0};
        int[] arrayMixed = new int[] {0, 5, -20, 30};
        Integer sum = getSumPositiveRange(arrayMixed);
        //    6: Найдите сумму всех нечетных элементов массива которые находятся на нечетных индексах.
        System.out.println("сумма всех нечетных элементов массива которые находятся на нечетных индексах: " + getOddSum(array));
        //    7: Найдите сумму всех четных элементов массива которые находятся на нечетных индексах.
        System.out.println("сумма всех четных элементов массива которые находятся на нечетных индексах: " + getEvenSum(array));
        //    8: Найдите произведение всех нечетных элементов массива.
        System.out.println("произведение всех нечетных элементов массива: " + getOddMultiplication(array));
        //    9: Найдите разность между максимальным и минимальным элементами массива.
        System.out.println("разность между максимальным и минимальным элементами массива: " + getDiffMaxMin(array));
        //    10: Найдите сумму элементов массива, которые находятся между первым и последним положительными элементами.
        System.out.println( sum != null ? "сумма элементов массива, которые находятся между первым и последним положительными элементами: " + sum : "нет позитивных чисел");
    }

    //    6: Найдите сумму всех нечетных элементов массива которые находятся на нечетных индексах.
    private static int getOddSum(int[] array) {
        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            if(array[i] % 2 != 0  && i % 2 != 0) {
                sum += array[i];
            }
        }

        return sum;
    }
//    7: Найдите сумму всех четных элементов массива которые находятся на нечетных индексах.
    private static int getEvenSum(int[] array) {
        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            if(array[i] % 2 == 0  && i % 2 != 0) {
                sum += array[i];
            }
        }

        return sum;
    }
//    8: Найдите произведение всех нечетных элементов массива.
    private static int getOddMultiplication(int[] array) {
        int mult = 1;

        for (int j : array) {
            if (j % 2 != 0) {
                mult = j * mult;
            }
        }

        return mult;
    }
//    9: Найдите разность между максимальным и минимальным элементами массива.
    private static int getDiffMaxMin(int[] array) {
        int min = array[0];
        int max = array[0];
        for (int j : array) {
            if (j > max) {
                max = j;
            }

            if (j < min) {
                min = j;
            }
        }

        return max - min;
    }
//    10: Найдите сумму элементов массива, которые находятся между первым и последним положительными элементами.
    private static Integer getSumPositiveRange(int[] array) {
        int firstPosIdx = 0;
        int lastPositiveIdx = 0;
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if(array[i] > 0) {
                count++;
                lastPositiveIdx = i;
            }
            if(count == 1) {
                firstPosIdx = i;
            }
        }
        if(lastPositiveIdx > firstPosIdx) {
            int sum = 0;
            int[] newArray = Arrays.copyOfRange(array, firstPosIdx, lastPositiveIdx);

            for (int num: newArray) {
                sum += num;
            }

            return sum;
        }

        return null;
    }
}
