package com.ifmo.jjd.lesson21.patterns.logging.decorator;

import com.ifmo.jjd.lesson21.patterns.logging.strategy.ILogger;

import java.time.LocalDateTime;

/**
 * Created by User on 07.05.2021.
 */
public class DateDecorator extends BaseDecorator {
    public DateDecorator(ILogger logger) {
        super(logger);
    }

    @Override
    public void log(String message) {
        String newMessage = message + " date: " + LocalDateTime.now();
        super.log(newMessage);
    }
}
