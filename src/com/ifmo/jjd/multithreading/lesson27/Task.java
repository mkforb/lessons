package com.ifmo.jjd.multithreading.lesson27;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * Created by User on 21.05.2021.
 */
public class Task implements Delayed {
    // У класса Task есть:
    private final Runnable action; // Инструкции, которые должны выполняться
    private final LocalDateTime time; // Время, когда они должны выполняться

    public Task(Runnable action, LocalDateTime time) {
        this.action = action;
        this.time = time;
    }

    public Runnable getAction() {
        return action;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        // Если метод возвращает 0 или отрицательное число, это означает, что его можно извлечь из очереди методом take().
        // Если положительное - элемент из очереди извлекаться не будет.
        return unit.convert(Duration.between(LocalDateTime.now(), time));
    }

    @Override
    public int compareTo(Delayed o) {
        // Элементы в очереди хранятся в отсортированном порядке, который определяется методом compareTo
        LocalDateTime otherTime = ((Task) o).time;
        return time.compareTo(otherTime);
    }
}
