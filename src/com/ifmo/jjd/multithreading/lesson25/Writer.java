package com.ifmo.jjd.multithreading.lesson25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by User on 14.05.2021.
 */
public class Writer extends Thread {
    // Класс потока
    // Это обычный класс. У него могут быть любые свойства, методы, конструкторы
    // Все что должно выполняться параллельно, находится в методе run()

    private CopyOnWriteArrayList<Course> courses;

    public Writer(CopyOnWriteArrayList<Course> courses) {
        this.courses = courses;
    }

    @Override
    public void run() {
        System.out.println("Writer");
        try (BufferedReader reader = new BufferedReader((new InputStreamReader(System.in)))) { // Аналог Scanner
            while (true) {
                // Thread.currentThread() - ссылка на текущий поток
                // Thread.currentThread().getName() - имя потока. Можно задать через setName(). Исп-ся для отладки
                System.out.println(Thread.currentThread().getName() + ": Введите данные");
                System.out.println("Введите название курса");
                String name = reader.readLine();
                System.out.println("Введите стоимость");
                int price = Integer.parseInt(reader.readLine()); // Integer.parseInt выдаст exception, если введенные данные не корректные
                System.out.println("Введите продолжительность");
                int duration = Integer.parseInt(reader.readLine());
                if (courses.addIfAbsent(new Course(name, duration, price))) { // addIfAbsent - добавляет эл. в конец списка, если такого элемента там нет. Используем, если несколько потокав работают со списком.
                    System.out.println("Курс успешно добавлен");
                } else {
                    System.out.println("Курс не был добавлен");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
