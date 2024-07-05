package homeworks.phaser;

import java.util.concurrent.Phaser;

public class PhaserExample {
    private static final Phaser PHASER = new Phaser(3); // Начальная фаза с одной партией (главный поток)
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
           // PHASER.register(); // Регистрируем новую партию
            new Thread(new Task(i)).start();

            PHASER.arriveAndAwaitAdvance(); // завершил выполнение фазы
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
