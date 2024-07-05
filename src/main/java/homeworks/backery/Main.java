package homeworks.backery;

public class Main {
    public static void main(String[] args) {
        Backery backery = new Backery();
        Producer producer = new Producer(backery);
        Consumer consumer = new Consumer(backery);

        Thread p_Thread = new Thread(producer);
        Thread c_Thread = new Thread(consumer);

        p_Thread.start();
        c_Thread.start();
    }
}
