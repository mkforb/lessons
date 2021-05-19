package com.ifmo.jjd.multithreading.lesson26.sync;

/**
 * Created by User on 19.05.2021.
 */
public class SynchronizedProblem {
    public static void main(String[] args) {
        Object object1 = new Object();
        Object object2 = new Object();

        Thread thread1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
            synchronized (object1) {
                try {
                    System.out.println("thread1, object1");
                    Thread.sleep(600);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (object2) {
                    System.out.println("thread1, object2");
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
            synchronized (object1) {
                try {
                    System.out.println("thread2, object2");
                    Thread.sleep(600);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (object2) {
                    System.out.println("thread2, object1");
                }
            }
        });

        thread1.start(); // Заблокировал object1
        thread2.start(); // Заблокировал object2
        // Приводит к взаимной блокировке. Чтобы исправить, нужно блокировать в одинаковой последовательности
    }
}
