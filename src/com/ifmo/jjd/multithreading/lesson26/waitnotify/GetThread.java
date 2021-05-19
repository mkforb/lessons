package com.ifmo.jjd.multithreading.lesson26.waitnotify;

/**
 * Created by User on 19.05.2021.
 */
// Такая конструкция называется Производитель-Потребитель, когда один поток создает, а другой читает
public class GetThread implements Runnable {
    private Library library;

    public GetThread(Library library) {
        this.library = library;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("Получена книга " + library.getBook());
                Thread.sleep((long) (Math.random() * 10000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
