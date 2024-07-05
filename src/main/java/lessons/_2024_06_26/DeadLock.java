package lessons._2024_06_26;

public class DeadLock {
    public static final Object LOCK1 = new Object();
    public static final Object LOCK2 = new Object();
}

class Lock1 extends Thread{

    @Override
    public void run() {
        synchronized (DeadLock.LOCK1){

        }
    }

}

class Lock2 extends Thread{

    @Override
    public void run() {
        super.run();
    }

}
