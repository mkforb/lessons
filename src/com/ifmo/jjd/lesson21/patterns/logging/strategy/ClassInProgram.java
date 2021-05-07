package com.ifmo.jjd.lesson21.patterns.logging.strategy;

/**
 * Created by User on 07.05.2021.
 */
public class ClassInProgram {
    private ILogger logger;

    public ClassInProgram(ILogger logger) {
        this.logger = logger;
    }

    public void setLogger(ILogger logger) {
        this.logger = logger;
    }

    public void action() {
        logger.log("Логирование действий");
    }
}
