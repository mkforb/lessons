package com.ifmo.jjd.multithreading.lesson27;

import java.time.LocalDateTime;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by User on 21.05.2021.
 */
public class BlockingQueue {
    public static void main(String[] args) {
        // При конструкторе без параметров максимальное кол-во элементов в очереди - Integer.MAX_VALUE
        LinkedBlockingQueue<String> stringLinked = new LinkedBlockingQueue<>(); // Блокирующие методы put и take
        // Можно задать макс. кол-во эл-тов в очереди
        stringLinked = new LinkedBlockingQueue<>(10);

        // Требует задачния кол-во элементов
        ArrayBlockingQueue<String> arrayQueue = new ArrayBlockingQueue<>(30); // Блокирующие методы put и take
        // put - добавляет эл. в очередь и блокирует, если очередь полная
        // take - удаляет эл. из очереди и блокирует, если очередь пустая
        arrayQueue = new ArrayBlockingQueue<>(30, true); // Помимо емкости принимает параметр справедливости fair
        // Если fair = true, очередь следит за очередностью. КАК???

        // Производитель - Потребитель
        // Кто-то добавляет в очередь, кто-то читает
        ArrayBlockingQueue<Signal> signals = new ArrayBlockingQueue<>(5, true);

        /*new Thread(new ReadSignals(signals)).start();
        new Thread(new WriteSignals(signals)).start();
        new Thread(new ReadSignals(signals)).start();
        new Thread(new ReadSignals(signals)).start();
        new Thread(new ReadSignals(signals)).start();
        new Thread(new ReadSignals(signals)).start();*/

        DelayQueue<Task> tasks = new DelayQueue<>(); // Классы, которые хотим хранить в такой очереди, должны импл. ИФ Delayed
        // У DelayQueue есть put() и take(). take() блокирует поток, но другим причинам
        tasks.put(new Task(() -> System.out.println("Old task"), LocalDateTime.now().minusDays(1)));
        tasks.put(new Task(() -> System.out.println("Future 1 task"), LocalDateTime.now().plusSeconds(10)));
        tasks.put(new Task(() -> System.out.println("Future 3 task"), LocalDateTime.now().plusSeconds(30)));
        // ["Future 3 task", "Future 1 task", "Old task"]

        while (true) {
            try {
                new Thread(tasks.take().getAction()).start();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
