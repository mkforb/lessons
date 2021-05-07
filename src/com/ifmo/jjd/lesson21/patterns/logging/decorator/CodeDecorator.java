package com.ifmo.jjd.lesson21.patterns.logging.decorator;

import com.ifmo.jjd.lesson21.patterns.logging.strategy.ILogger;

import java.util.UUID;

/**
 * Created by User on 07.05.2021.
 */
public class CodeDecorator extends BaseDecorator {
    public CodeDecorator(ILogger logger) {
        super(logger);
    }

    @Override
    public void log(String message) {
        String newMessage = message + " " + UUID.randomUUID();
        super.log(newMessage);
    }
}
