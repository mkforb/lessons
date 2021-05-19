package com.ifmo.jjd.multithreading.lesson26.sync;

/**
 * Created by User on 19.05.2021.
 */
public class Account {
    private int balance;

    public Account(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    // public synchronized void changeBalance(int count) { // Модификатором synchronized можно отметить метод, которые используется в потоках
    public void changeBalance(int count) {
        balance += count;
    }
}
