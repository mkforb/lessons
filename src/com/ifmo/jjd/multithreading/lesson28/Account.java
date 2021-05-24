package com.ifmo.jjd.multithreading.lesson28;

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

    public void changeBalance(int count) {
        balance += count;
    }
}
