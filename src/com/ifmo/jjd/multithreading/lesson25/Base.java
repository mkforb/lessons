package com.ifmo.jjd.multithreading.lesson25;

/**
 * Created by User on 14.05.2021.
 */
public class Base {
    // Жизненный цикл потока:
    // 1. NEW - создан поток (создание экз. Thread), создан, но работать не начал
    // 2. RUNNABLE - (вызов метода start() объект Thread) передаем поток на управление планировщику потоков. Планировщиком управлять нельзя, можно рекомендовать.
    // 3. RUNNING - планировщик запустил поток, поток запущен. Время запуска потока определяется планировщиком.
    // 4. NON-RUNNING - поток в состоянии ожидания (может перейти в него, а может и нет)
    // 5. TERMINATED - поток заршил свою работу

    public static void main(String[] args) {

        // Вариант 1
        Writer writer = new Writer(); // NEW
        writer.start(); // RUNNABLE

        // Вариант 2
        Reader reader = new Reader();
        Thread readerThread = new Thread(reader); // NEW
        readerThread.start(); // RUNNABLE

        // Вариант 3
        Runnable runnable = () -> {
            System.out.println("lambdaThread");
        };
        Thread lambdaThread = new Thread(runnable); // NEW
        lambdaThread.start();

    }

}
