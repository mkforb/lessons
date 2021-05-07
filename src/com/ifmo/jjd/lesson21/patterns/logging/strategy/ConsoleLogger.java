package com.ifmo.jjd.lesson21.patterns.logging.strategy;

/**
 * Created by User on 07.05.2021.
 */
public class ConsoleLogger implements ILogger {
    @Override
    public void log(String message) {
        System.out.println(message);
    }
}
