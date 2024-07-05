package homeworks.backery;

public class Backery {
    private final Object LOCK = new Object();
    private int breadCounter = 0;
//    private int eggCounter = 0;

    private int flourCounter = 0;

    public void sellBread() {
        synchronized (LOCK) {
            while (breadCounter < 1) {
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            try {
                Thread.sleep(123);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            breadCounter--;
            System.out.println("Cunsumer: " + breadCounter);
            LOCK.notifyAll();
        }
    }

    public void makeBread() {
        synchronized (LOCK) {
            while (breadCounter >= 5) {
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            try {
                Thread.sleep(234);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            breadCounter++;
            flourCounter--;
            System.out.println("Producer: " + breadCounter);
            LOCK.notifyAll();
        }

    }

    public void getFlour() {
        while (flourCounter >= 5) {
            try {
                LOCK.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        try {
            Thread.sleep(234);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        flourCounter ++;
        System.out.println("Producer: " + flourCounter);
        LOCK.notifyAll();
    }

//    public void getEggs() {
//        while (eggCounter < 1) {
//            try {
//                LOCK.wait();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//
//        try {
//            Thread.sleep(234);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        eggCounter += 10;
//        System.out.println("Producer: " + eggCounter);
//        LOCK.notify();
//    }

}

class Producer implements Runnable {
    private Backery backery;

    public Producer(Backery backery) {
        this.backery = backery;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            backery.getFlour();
            backery.makeBread();
//            backery.getEggs();

        }
    }
}

class Consumer implements Runnable {
    private Backery backery;

    public Consumer(Backery backery) {

        this.backery = backery;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            backery.sellBread();
        }
    }
}
