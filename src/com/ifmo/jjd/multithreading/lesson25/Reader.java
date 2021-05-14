package com.ifmo.jjd.multithreading.lesson25;

/**
 * Created by User on 14.05.2021.
 */
public class Reader implements Runnable { // implements Runnable используется, чтобы можно было отнаследоваться от другого класса
    // На данный момент класс Reader потоком не является
    // Все что должно выполняться параллельно, находится в методе run()

    @Override
    public void run() {
        System.out.println("Reader");
    }
}
