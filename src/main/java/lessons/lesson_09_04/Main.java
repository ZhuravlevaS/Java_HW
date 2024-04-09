package lessons.lesson_09_04;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(getArray(10, 5)));

        int[][] array = {{2, 3,	5, 6, 9},
                        {4,	7,	8,	11,	13},
                        {14, 19, 25, 26, 27},
                        {15, 21, 28, 33, 36},
                        {24, 29, 44, 55, 66}};

        System.out.println(isNumInclude(array, 21));

    }

    private static int[][] getArray(int high, int width) {
        Random random = new Random();
        int[][] newArray = new int[high][width];

         for (int i = 0; i < high; i++) {
            for (int j = 0; j < width; j++) {
                newArray[i][j] = random.nextInt();
            }
        }

         return newArray;
    }

    private static boolean isNumInclude(int[][] matrix, int number) {
        for (int[] ints : matrix) {
            for (int j = ints.length - 1; j > 0; j--) {
                if (ints[j] < number) {
                    break;
                }

                if (ints[j] == number) {
                    return true;
                }
            }
        }
        return false;
    }

}
