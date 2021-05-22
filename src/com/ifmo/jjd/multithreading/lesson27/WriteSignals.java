package com.ifmo.jjd.multithreading.lesson27;

import java.util.Objects;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by User on 21.05.2021.
 */
public class WriteSignals implements Runnable {
    private ArrayBlockingQueue<Signal> signals;

    public WriteSignals(ArrayBlockingQueue<Signal> signals) {
        this.signals = Objects.requireNonNull(signals);
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " запущен");
        while (!Thread.currentThread().isInterrupted()) {
            Signal signal = Signal.getSignal();
            try {
                Thread.sleep(5000);
                signals.put(signal);
                System.out.println(Thread.currentThread().getName() + " Элемент добавлен");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
    }
}
