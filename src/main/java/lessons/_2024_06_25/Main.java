package lessons._2024_06_25;

public class Main {
    public static void main(String[] args) {
        int[][] a = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        int[][] array2 = convertArray(a);
        for (int[] ints : array2) {
            System.out.println(ints[0] + " " + ints[1] + " " + ints[2]);
        }
    }

    private static int[][] convertArray(int[][] array) {
        int length = array.length;
        int[][] newArray = new int[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                newArray[i][j] = array[length-1-j][i];
            }
        }

        return newArray;
    }
}
