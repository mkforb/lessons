package com.ifmo.jjd.multithreading.lesson27.homework27;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by User on 24.05.2021.
 */
public class Client implements Runnable {
    private ArrayBlockingQueue<Order> clientWaiter;
    private ArrayBlockingQueue<Order> clientCook;

    public Client(ArrayBlockingQueue<Order> clientWaiter, ArrayBlockingQueue<Order> clientCook) {
        this.clientWaiter = clientWaiter;
        this.clientCook = clientCook;
    }

    @Override
    public void run() {
        Order order = new Order();
        try {
            clientWaiter.put(order);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            System.out.println(clientCook.take());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
