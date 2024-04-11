package homeworks.homework_25_03;

import java.util.Arrays;

public class PartOne {
    public static void main(String[] args) {
        int[] array = new int[] {2, 3, 4, 5, 7, 2, 30};

//    1: Найдите сумму всех нечетных элементов массива.
        System.out.println("сумму всех нечетных элементов массива: " + getOddSum(array));
//    2: Найдите максимальный элемент в массиве.
        System.out.println("максимальный элемент в массиве: " + getMaxElement(array));
//    3: Проверьте, содержит ли массив заданный элемент.
        System.out.println("содержит ли массив заданный элемент: " + (checkElem(array, 9) ? "да" : "нет"));
//   4: Посчитайте, сколько раз заданный элемент встречается в массиве.
        System.out.println("сколько раз заданный элемент встречается в массиве: " + getNumberElem(array, 0));
//    5: Инвертируйте элементы массива.
        System.out.println("Инвертируйте элементы массива: " + Arrays.toString(reverseArray(array)));
    }

//    1: Найдите сумму всех нечетных элементов массива.
    private static int getOddSum(int[] array) {
        int sum = 0;

        for (int element: array) {
            if(element % 2 != 0) {
                sum += element;
            }
        }

        return sum;
    }
//    2: Найдите максимальный элемент в массиве.
    private static int getMaxElement(int[] array) {
        int max = array[0];

        for (int elem: array){
            if(elem > max){
                max = elem;
            }
        }

        return max;
    }
//    3: Проверьте, содержит ли массив заданный элемент.
    private static boolean checkElem(int[] array, int element) {
       for (int currentElem: array) {
            if(currentElem == element) {
                return true;
            }
        }

        return false;
    }
//   4: Посчитайте, сколько раз заданный элемент встречается в массиве.

    private static int getNumberElem(int[] array, int element) {
        int value = 0;

        for (int currentElem: array) {
            if(currentElem == element) {
                value += 1;
            }
        }

        return value;
    }

//    5: Инвертируйте элементы массива.
    private static int[] reverseArray(int[] array) {
        int[] newArray = Arrays.copyOf(array, array.length);
        int middleIdxArray = array.length/2;

        for (int i = 0; i < middleIdxArray; i++) {
            newArray[i] = array[array.length - i -1];
            newArray[array.length - i -1] = array[i];
        }

        return newArray;
    }
}
