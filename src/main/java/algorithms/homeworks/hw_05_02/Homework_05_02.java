package algorithms.homeworks.hw_05_02;

public class Homework_05_02 {
    public static void main(String[] args) {
        System.out.println(checkIfSquare(4, 2));
        showCubes(5);
    }

    //    Найти сумму трёх чисел
    private static int getSum(int num1, int num2, int num3) {
        return num1 + num2 + num3;
    }

    //    По двум заданным числам проверять является ли одно квадратом другого
    private static boolean checkIfSquare(double num1, double num2) {
        double squareNum1 = Math.pow(num1, 2);

        if (num2 == squareNum1) {
            return true;
        }

        double squareNum2 = Math.pow(num2, 2);

        if (num1 == squareNum2) {
            return true;
        }

        return false;
    }

//     На промежутке от 1 до N, показать кубы чисел, заканчивающихся на четную цифру

    private static void showCubes(int n) {
        int counter = 1;

        while (counter < n) {
            double cube = Math.pow(counter, 3);
            counter++;
            if (cube % 2 == 0) {
                System.out.println(cube);
            }
        }
    }
}
