package com.ifmo.jjd.multithreading.lesson28;

import java.util.HashSet;
import java.util.concurrent.Semaphore;

/**
 * Created by User on 24.05.2021.
 */
public class SemaphoreExample {
    public static void main(String[] args) {
        // Для управления доступом к ресурсам. Когда обращаются к одному объекту
        Semaphore semaphore = new Semaphore(1);
        // 1 - кол-во разрешений. Если кол-во > 0, то поток может получить доступ к ресурсу
        // Если кол-во разрешений = 0, то поток доступ к ресурсу не получит и поток будет заблокирован
        // Семафор общий для всех потоков
        semaphore = new Semaphore(1, true); // Если флаг флаг справедливости true,
        // то доступ к семафору потоки получат в той последовательности, в которой обращались к нему
        // Иначе в произвольном

        HashSet<String> set = new HashSet<>(); // Ресурс

        Semaphore finalSemaphore = semaphore;
        Runnable runnable = () -> {
            String threadName = Thread.currentThread().getName();
            try {
                Thread.sleep(3000);
                // Перед тем как исп. общ. рес., поток вызывает метод:
                finalSemaphore.acquire(); // Уменьшает кол-во разрешений на 1
                // semaphore.acquire(n); // Принимает кол-во разрешений, на которое надо уменьшить кол-во разрешений
                set.add(threadName);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                finalSemaphore.release(); // Увелич. кол-во разрешений на 1
                // finalSemaphore.release(n); // Отдать n разрешений
                // Лучше высвобождать ресурсы в блоке finally на случай, если в блоке try случится необрабатываемый exception,
                // чтобы ресурс не остался заблокированным
            }
        };

        // Если есть потоки, которые меняют состояние и читают состояние объекта, то
        // поток, который меняет состояне, то он забирает все разрешения, а
        // которые читают - забирает по одному
    }
}
