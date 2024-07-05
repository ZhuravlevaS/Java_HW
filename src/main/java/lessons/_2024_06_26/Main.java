package lessons._2024_06_26;

public class Main extends Thread {
    public static void main(String[] args) {
        Thread t1 = new Main();
        t1.start();
    }

    public void run() {
        System.out.println("Run");
    }
}

class Run1 implements Runnable {

    @Override
    public void run() {
        System.out.println("Run1");
    }

    public static void main(String[] args) {
        Thread t2 = new Thread(new Run1());
        t2.start();
    }
}