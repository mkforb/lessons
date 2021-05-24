package com.ifmo.jjd.multithreading.lesson28;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by User on 24.05.2021.
 */
public class CustomExecutor extends ThreadPoolExecutor {
    // Если нужно гибко настроить пул потоков, создаем свой класс и наследуем от ThreadPoolExecutor

    public CustomExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
        // corePoolSize - начальное кол-во потоков в пуле
        // maximumPoolSize - максимальное кол-во потоков, если потоков не хватает, то будут создаваться потоки, но не больше чем это кол-во
        // keepAliveTime - сколько поток будет простаивать прежде чем будет удален из пула
        // unit - ЕИ к keepAliveTime
        // workQueue - очередь для задач пула
    }

    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        super.beforeExecute(t, r);
        // Можно переопределить, если нужно что-то выполнить перед запуском (перед запуском чего? потока?)
        // Модификатор доступа можно поменять в сторону расширения, напр., protected -> public
    }
}
