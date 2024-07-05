package lessons._06_21;

import java.util.ArrayList;
import java.util.List;

public class Thread2 {

    private static List<Integer> numbers = new ArrayList<>();
    private static int sum = 0;

    private static void generateList() {
        for (int i = 0; i < 100; i++) {
            numbers.add(1);
        }
    }

    private static int sumFirstPart() {
        int lastIdx = numbers.size() / 2;

        return numbers.subList(0, lastIdx).stream()
                .mapToInt(s -> s)
                .sum();
    }

    private  static int sumLastPart() {
        int firstIdx = numbers.size() / 2;

        return numbers.subList(firstIdx, numbers.size()).stream()
                .mapToInt(s -> s)
                .sum();
    }

    public static void main(String[] args) throws InterruptedException {
            generateList();


            Thread t1 = new Thread(() -> {
                sum += sumFirstPart();
            });

            Thread t2 = new Thread(() -> {
                sum += sumLastPart();
            });

            t1.start();
            t1.join();
            t2.start();
            t2.join();
            System.out.println(sum);




    }

}
