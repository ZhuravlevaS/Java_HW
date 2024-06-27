package algorithms.lesson_05_16;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] list = {0, 1, 4, 0, 7, 2, 1};
        System.out.println(Arrays.toString(sortArray(list)));
    }

    public static int[] sortArray(int[] list) {
        int[] newList = new int[list.length];
        int count = 0;
        for (int j : list) {
            if (j != 0) {
                newList[count] = j;
                count++;
            }
        }

        return newList;
    }
}
