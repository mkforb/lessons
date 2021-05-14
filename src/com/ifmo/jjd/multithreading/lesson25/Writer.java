package com.ifmo.jjd.multithreading.lesson25;

/**
 * Created by User on 14.05.2021.
 */
public class Writer extends Thread {
    // Класс потока
    // Это обычный класс. У него могут быть любые свойства, методы, конструкторы
    // Все что должно выполняться параллельно, находится в методе run()

    @Override
    public void run() {
        System.out.println("Writer");
    }
}
