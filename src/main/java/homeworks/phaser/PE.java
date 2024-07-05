package homeworks.phaser;

import java.util.concurrent.Phaser;

public class PE {
    private static final Phaser PHASER = new Phaser(1); // Начальная фаза с одной партией (главный поток)

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            PHASER.register(); // Регистрируем новую партию
            new Thread(new PhaserExample.Task(i)).start();
            if (i == 1) {
               PHASER.register(); // Регистрируем новую партию
                new Thread(new PhaserExample.Task(5)).start();
            }
            PHASER.arriveAndAwaitAdvance();
        }
        System.out.println("Главный поток завершен.");
    }

    static class Task implements Runnable {
        private int taskNumber;

        public Task(int taskNumber) {
            this.taskNumber = taskNumber;
        }

        @Override
        public void run() {
            System.out.println("Выполняется: " + "фаза " + PHASER.getPhase() + ", таска " + taskNumber);

            try {
                Thread.sleep(500); // Имитация работы потока
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            int arr = PHASER.arrive(); // Сообщаем о завершении текущей фазы
            System.out.println("Завершил фазу: " + arr + ", таска " + taskNumber);

            PHASER.arriveAndDeregister();
        }
    }
}
