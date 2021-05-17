package com.ifmo.jjd.multithreading.lesson25;

/**
 * Created by User on 17.05.2021.
 */
public class DaemonThreads {
    public static void main(String[] args) {
        // Демон-потоки - фоновые потоки. Работают, пока есть хотя бы один не демон-поток
        Thread daemon = new Thread(() -> {
            while (true) {
                System.out.println("фоновый (демон) поток");
            }
        });
        daemon.setDaemon(true); // Определяем демон-поток. Завершит несмотря на то что у него там внутри
        //daemon.start();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Прерывание потоков
        // Метод stop() устарел. Его не использовать.
        // Других методов для остановки нет
        // Поток останавливается, если:
        // 1. Поток завершил выполнение всех своих инструкций
        // 2. В потоке выборшено необработанное исключение
        // 3. Поток был демон-потоком и все не демон-потоки завершили свои инструкции

        // Механизм прерывания потоков
        // (interrupted, interrupt(), isInterrupted())
        Thread thread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("Some actions...");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread.interrupt(); // Меняет сво-во interrupt с false на true.

        // Если поток в состоянии ожидания и в этот момент у него вызывается interrupt(), то случится InterruptedException
        // Оно изменит interrupt обратно на false

        // Д/з: Понять как работает interrupt
    }
}
