package lessons._06_21;

public class Thread1 {
    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            for (int i = 0; i < 50; i++) {
                System.out.println("T1" + " " + i);
            }
        });

        Thread t2 = new Thread(()->{
            for (int i = 50; i > 0; i--) {
                System.out.println("T2"  + " " + i);
            }
        });

        t1.start();
        t2.start();
    }
}
