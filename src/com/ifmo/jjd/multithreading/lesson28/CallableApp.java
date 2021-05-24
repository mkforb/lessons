package com.ifmo.jjd.multithreading.lesson28;

import com.ifmo.jjd.multithreading.lesson27.Signal;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by User on 24.05.2021.
 */
public class CallableApp {
    public static void main(String[] args) {
        CustomExecutor executor = new CustomExecutor(1, 6, 1000, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>());

        // Передать задачу на выполнение пулу
        // Runnable - execute()
        // Callable - submit()
        Callable<Signal> signalGenerator = new SignalGenerator();
        // Метод execute() нельзя вызывать, так как он ничего не возвращает (??)
        Future<Signal> container1 = executor.submit(signalGenerator); // Результат выполнения задачи signalGenerator окажется в контейнере container1
        Future<Signal> container2 = executor.submit(signalGenerator);
        Future<Signal> container3 = executor.submit(signalGenerator);
        executor.shutdown();

        /*try {
            System.out.println("Signal 1 " + container1.get());
            // container1.get() сразу ничего не вернет.
            // Текущий поток, т.е. поток main, приостановится и будет ждать.
            // get() выполнится, когда в контейнере появятся данные
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        try {
            System.out.println("Signal 2 " + container2.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        try {
            System.out.println("Signal 3 " + container3.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }*/

        try {
            System.out.println("Signal 1 " + container1.get(2000, TimeUnit.SECONDS));
            // Принимает на вход время, сколько он будет ждать данных в контейнере
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            // Если по прошествии заданного времени данные не появились, то будет выброшен TimeoutException
            System.out.println("Данные не появились");
        }

        CustomExecutor executor2 = new CustomExecutor(1, 6, 1000, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>());

        // Можно список задач передать в очередь, если задачи возвращают однотипные данные
        List<Callable<Signal>> callables = new ArrayList<>();
        callables.add(new SignalGenerator());
        callables.add(new SignalGenerator());
        callables.add(new SignalGenerator());

        List<Future<Signal>> futures = null;
        try {
            futures = executor2.invokeAll(callables);
            // Возвращает список контейнеров с результатами
            executor2.shutdown(); // Останавливаем пул, чтобы больше не принимать задачи
            for (Future<Signal> container : futures) {
                System.out.println(container.get());
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        // Future:
        // .isDone() - возвращает true, если задача завершена
        // .cancel() - отменить задачу
        // .isCanceled() - возвращает true, если задача была отменена
        // .
    }
}
