package com.ifmo.jjd.multithreading.lesson25;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by User on 14.05.2021.
 */
public class Base {
    // Жизненный цикл потока:
    // 1. NEW - создан поток (создание экз. Thread), создан, но работать не начал
    // 2. RUNNABLE - (вызов метода start() объект Thread) передаем поток на управление планировщику потоков. Планировщиком управлять нельзя, можно рекомендовать.
    // 3. RUNNING - планировщик запустил поток, поток запущен. Время запуска потока определяется планировщиком.
    // 4. NON-RUNNING (TIME WAITING) - поток в состоянии ожидания (может перейти в него, а может и нет)
    // 5. TERMINATED - поток заршил свою работу

    // Используется:
    // - Один поток работает с пользовательским интерфейсом (консоль, графический), другой работает с данными
    // - Для обработки больших объемов данных
    // - Запуск по таймеру

    public static void main(String[] args) {
        // Если поток main завершит работу, то другие потоки не завершатся, пока не выполнят свои инструкции.
        // Если в каком-то из потоков случится RuntimeException, на другие потоки это не повлияет.

        // ArrayList для многопоточности
        CopyOnWriteArrayList<Course> courses = new CopyOnWriteArrayList<>();
        // Ни одна коллекция, кроме блокирующих очередей, не заблокирует получаетеля, если там нет данных

        // Какой поток запустится первым, мы не знаем. Это как решит планировщик потоков

        // Надо контролировать, чтобы во время ввода в консоль данных пользователем, другой поток не делал вывод в консоль

        // Вариант 1
        Writer writer = new Writer(courses); // NEW
        writer.setName("WRITER");
        writer.start(); // RUNNABLE

        // Вариант 2
        Reader reader = new Reader(courses);
        Thread readerThread = new Thread(reader); // NEW
        readerThread.start(); // RUNNABLE

        // Вариант 3
        Runnable runnable = () -> {
            System.out.println("lambdaThread");
        };
        Thread lambdaThread = new Thread(runnable); // NEW
        lambdaThread.start();

        // Приоритет носит рекомендательный харакатер для планировщика
        // От 1 до 10 (мин и макс приоритет)
        // По умолчанию - 5
        // На приоритетах нельзя строить логику программ

        Thread reader2 = new Thread(new Reader(courses));
        Thread reader3 = new Thread(new Reader(courses));
        Thread reader4 = new Thread(new Reader(courses));

        reader2.setPriority(Thread.MAX_PRIORITY); // 10
        reader3.setPriority(7);
        reader4.setPriority(Thread.MIN_PRIORITY);

        System.out.println(reader2.getPriority());

        reader4.start();
        reader3.start();
        reader2.start();

        System.out.println(Runtime.getRuntime().availableProcessors());

    }

}
