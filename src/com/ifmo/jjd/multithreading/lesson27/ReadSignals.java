package com.ifmo.jjd.multithreading.lesson27;

import java.util.Objects;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by User on 21.05.2021.
 */
public class ReadSignals implements Runnable {
    private ArrayBlockingQueue<Signal> signals;

    public ReadSignals(ArrayBlockingQueue<Signal> signals) {
        this.signals = Objects.requireNonNull(signals);
    }

    @Override
    public void run() {
        // Этот поток никогда не остановится
        System.out.println(Thread.currentThread().getName() + " запущен");
        while (true) {
            try {
                System.out.println(Thread.currentThread().getName() + " Элемент получен " + signals.take()); // take() блокирует поток, если очередь пустая
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
