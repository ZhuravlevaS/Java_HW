package lessons.lesson_09_04;


public class Task {
    public static void main(String[] args) {
        int[][] array = {{2, 3,	5, 6, 9},
                {4,	7,	8,	11,	13},
                {14, 19, 25, 26, 27},
                {15, 21, 28, 33, 36},
                {24, 29, 44, 55, 66}};

        System.out.println(isNumInclude(array, 15));
    }
    /**
     *
     * @param matrix матрица в которой все числа отсортированы справа налево и сверху вниз
     * @param number число которое ищем
     * @return true - если число есть матрице
     */
    private static boolean isNumInclude(int[][] matrix, int number) {
        for (int[] ints : matrix) {
            for (int j = ints.length - 1; j >= 0; j--) {
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
