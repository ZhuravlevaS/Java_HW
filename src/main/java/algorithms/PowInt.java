package algorithms;

public class PowInt {

    public static void main(String[] args) {
        double pow1 = Math.pow(5, 5);
        double pow2 = pow(5, 5);

        System.out.println(pow1);
        System.out.println(pow2);
    }

    private static double pow(int a, int power) {
        if (power == 0) {
            return 1;
        } else {
            if (power % 2 == 0) {
                return pow(a * a, power / 2);
            } else {
                return a * pow(a, power - 1);
            }
        }
    }
}
