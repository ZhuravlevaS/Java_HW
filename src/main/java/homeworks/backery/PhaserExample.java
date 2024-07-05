package homeworks.backery;

import java.util.concurrent.Phaser;

public class PhaserExample {
    volatile static int count;
    private static final Phaser PHASER = new Phaser(1); // Начальная фаза с одной партией (главный поток)

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            PHASER.register(); // Регистрируем новую партию
            new Thread(new Task(i)).start();

            PHASER.arriveAndAwaitAdvance();
        }
    }

    static class Task implements Runnable {
        private int taskNumber;

        public Task(int taskNumber) {
            this.taskNumber = taskNumber;
        }

        @Override
        public void run() {
            System.out.println("Таска: " + taskNumber + " выполняет фазу " + PHASER.getPhase());
            PHASER.arriveAndAwaitAdvance(); // сообщаем, что первая фаза достигнута

            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }

            if (taskNumber == 0) {
                System.out.println("Таска: " + taskNumber + " выполняет фазу " + PHASER.getPhase());
                PHASER.arriveAndAwaitAdvance(); // сообщаем, что вторая фаза достигнута

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    System.out.println(ex.getMessage());
                }

                System.out.println("Таска: " + taskNumber + " выполняет фазу " + PHASER.getPhase());
                PHASER.arriveAndAwaitAdvance(); // сообщаем, что третья фаза достигнута

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    System.out.println(ex.getMessage());
                }
            }

            PHASER.arriveAndDeregister(); // сообщаем о завершении фаз и удаляем с регистрации объекты

            System.out.println("Таска: " + taskNumber + " закончила");
        }
    }
}
