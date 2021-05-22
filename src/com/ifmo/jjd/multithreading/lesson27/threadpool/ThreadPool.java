package com.ifmo.jjd.multithreading.lesson27.threadpool;

import java.time.LocalTime;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by User on 21.05.2021.
 */
public class ThreadPool {
    public static void main(String[] args) {
        // Когда возможно, надо использовать пул потоков
        // пул потоков [thread1, thread2]
        // task queue (объекты, имплементирующие Runnable/Collable) [task1, task2, task3, task4]
        // Потоки из пула по очереди берут задачи из очереди. Поток, который освобождается, берет след. задачу из очереди задач
        // В задачах не должно быть бесконечных циклов
        // Схожие задачи должны (или могут?) быть в одном пуле потоков
        // В очереди не должно быть задач, которые ждут результатов работы других задач
        // Не надо создавать много потоков (6-10)

        // ExecutorService - пул потоков
        ExecutorService fixedPool = Executors.newFixedThreadPool(2); // Для FixedThreadPool надо указать кол-во потоков в пуле
        for (int i = 0; i < 20; i++) {
            int iv = i;
            fixedPool.execute(() -> System.out.println("Task " + iv));
            // execute() - это не немедленное выполнение. Задача помещается в очередь. Потоки выполнят ее, когда будут готовы.
        }
        // fixedPool.shutdown(); // Пул закрывается. После вызова shutdown() пул не принимает новых задач, но текущие задачи он завершит.
        // После вызова shutdown() к пулу обращаться нельзя
        // Ничего не возвращает

        List<Runnable> runnables = fixedPool.shutdownNow(); // Прекращает выполнение задач немедленно. Начатые задачи завершит, новые не начнет.
        // Вернет список невыполненных задач
        System.out.println(runnables);

        ExecutorService single = Executors.newSingleThreadExecutor(); // Создает пул на один поток
        // Задачи выполняются последовательно, параллельно main'у
        single.execute(() -> {
            System.out.println("Task 1");
        });
        single.execute(() -> {
            System.out.println("Task 2");
        });
        single.shutdown();

        ScheduledExecutorService service1 = Executors.newSingleThreadScheduledExecutor(); // Пул, который может выполнять потоки по расписанию
        // Отложенное выполнение:
        service1.schedule(() -> {
            System.out.println("service1");
        }, 5, TimeUnit.SECONDS);
        // Если не закрыть, то будет ждать новых заданий
        service1.shutdown();


        ScheduledExecutorService service2 = Executors.newSingleThreadScheduledExecutor();
        service2.scheduleAtFixedRate(() -> {
            System.out.println("service2");
        }, 0, 5, TimeUnit.SECONDS);
        // Запуск будет происходить через 5 секунд после начала предыдущей, независимо завершилась ли предыдущая
        // Время задачи не учитывается.
        // Повторяется бесконечно
        // Если задача не успеет выполниться за указанное время, пул переполнится и будет ошибка

        ScheduledExecutorService service3 = Executors.newSingleThreadScheduledExecutor();
        service3.scheduleWithFixedDelay(() -> {
            System.out.println(LocalTime.now() + " service3");
        }, 0, 2, TimeUnit.SECONDS);
        service3.scheduleWithFixedDelay(() -> {
            System.out.println(LocalTime.now() + " service3b");
        }, 0, 3, TimeUnit.SECONDS);
        // Следующая задача начнется через 2 секунды после завершения предыдущей

        // Если создается пул на фикс. кол-во потоков или пул, где можно указать макс. кол-во потоков, то надо указывать кол-во,
        // равное кол-ву ядер Runtime.getRuntime().availableProcessors()
        // n * ( 1 + w / s) - если задача предполагаются операции ввода вывода
        // n - Runtime.getRuntime().availableProcessors() (?)
        // w - приблизительное время ожидания
        // s - сколько нужно на выполнение инструкций
    }
}
