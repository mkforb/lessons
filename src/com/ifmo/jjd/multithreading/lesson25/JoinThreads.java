package com.ifmo.jjd.multithreading.lesson25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by User on 17.05.2021.
 */
public class JoinThreads {
    public static void main(String[] args) {
        List<Integer> results = Collections.synchronizedList(new ArrayList<>()); // Обычный ArrayList завернут в synchronizedList, вернет потокобезопасный List, но не оптимальный
        // Лучше использовать потокобезопасные коллекции вместо synchronized, они производительнее

        Thread thread1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " Введите число");
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
                results.add(Integer.parseInt(reader.readLine()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " обработал данные");
            results.add(100);
        });

        Thread thread3 = new Thread(() -> {
            try {
                Thread.sleep(7000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " обработал данные");
            results.add(200);
        });

        thread1.start();
        thread2.start();
        thread3.start();

        // Нам нужно, чтобы поток main дождался выполнения трех потоков

        try {
            thread1.join(10000); // Поток main приостанавливается и ждет, пока выполнится поток thread1. Будет ждать бесконечно (если вызвать без параметра)
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + ": " + results);

        // Если не задать имя потока, то будет присваиваться имя Thread-<число>. Число - в порядке запуска метода start() у потока

        // Д/з: Понять джойны

    }
}
