package com.ifmo.jjd.multithreading.lesson28;

import com.ifmo.jjd.multithreading.lesson27.Signal;

import java.util.concurrent.Callable;

/**
 * Created by User on 24.05.2021.
 */
public class SignalGenerator implements Callable<Signal> {
    // Альтернатива Runnable
    // У него нет метода run(), а есть call()
    // Отличия:
    // Callable нельзя передать в конструктор Thread(), потому что у Thread нет такого конструктора
    // Работает с пулом потоков

    @Override
    public Signal call() throws Exception {
        // Может возвращать данные заданного типа (так как ИФ - дженерик) и бросать Exception
        // Но мы не знаем когда он начнет выполняться и когда вернет
        // Напрямую call() вызывать нельзя
        Thread.sleep((long)(Math.random()*3000));
        return Signal.getSignal();
    }
}
