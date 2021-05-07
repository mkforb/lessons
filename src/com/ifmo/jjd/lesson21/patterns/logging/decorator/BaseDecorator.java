package com.ifmo.jjd.lesson21.patterns.logging.decorator;

import com.ifmo.jjd.lesson21.patterns.logging.strategy.ILogger;

/**
 * Created by User on 07.05.2021.
 */
public abstract class BaseDecorator implements ILogger {
    private ILogger logger;

    // Конструктор принимает на вход то, что будем декорировать
    public BaseDecorator(ILogger logger) {
        this.logger = logger;
    }

    @Override
    public void log(String message) {
        logger.log(message);
    }
}
