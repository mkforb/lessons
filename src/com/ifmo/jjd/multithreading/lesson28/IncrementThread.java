package com.ifmo.jjd.multithreading.lesson28;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by User on 19.05.2021.
 */
public class IncrementThread extends Thread {
    private final Account account;
    private ReentrantLock lock;

    public IncrementThread(Account account, ReentrantLock lock) {
        this.account = account;
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.lock(); // Перед тем как менять объект, вызвали блокировку
        try {
            account.changeBalance(10);
        } finally {
            // Разблокировку делаем в finally, чтобы блокировка не осталась на случай, если в try будет exception
            lock.unlock();
        }

    }
}
