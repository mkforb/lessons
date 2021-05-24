package com.ifmo.jjd.multithreading.lesson28;

import java.util.ArrayList;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by User on 24.05.2021.
 */
public class Lock {
    public static void main(String[] args) {
        // Альтернатива synchronized

        Account account = new Account(0);
        ReentrantLock lock = new ReentrantLock();

        // У потоков, которые вместо synchronized хотят использвать блокировку, принимают на вход ссылку на блокировщик

        ArrayList<IncrementThread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            threads.add(new IncrementThread(account, lock));
        }

        ReadWriteLock readWriteLock = new ReentrantReadWriteLock(); // Разные блокировки для читающих и пищущих потоков
        // Для пищущих потоков:
        readWriteLock.writeLock().lock(); // блокировка
        // Меняет состояние
        readWriteLock.writeLock().unlock(); // разблокировка
        // Если заблокирован в режиме записи, то никто другой не сможет обратиться

        // Для читающих потоков:
        readWriteLock.readLock().lock();
        // Получение данных
        readWriteLock.readLock().unlock();
        // Если заблокирован в режиме чтения, то другие смогут читать. А писать???
    }
}
