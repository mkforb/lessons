package com.ifmo.jjd.multithreading.lesson26.sync;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 19.05.2021.
 */
public class SyncApp {
    public static void main(String[] args) {
        Account account = new Account(0);
        ArrayList<IncrementThread> threads = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            threads.add(new IncrementThread(account));
        }

        threads.forEach(incrementThread -> incrementThread.start());
        threads.forEach(incrementThread -> {
            try {
                incrementThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println("Balance = " + account.getBalance());

        // Объект account не блокируется, несколько потоков могут одновременно обратиться к нему и одновременно изменить

        // Задание!!!
        // List<String> list =  Files.readAllLines(Path.of("путь к файлу")); // читает из файла, одна строка файла - один элемент списка
        // Поделить на кол-во потоков
    }
}
