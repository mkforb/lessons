package com.ifmo.jjd.lesson21.patterns.logging.strategy;

import com.ifmo.jjd.lesson21.patterns.logging.decorator.CodeDecorator;
import com.ifmo.jjd.lesson21.patterns.logging.decorator.DateDecorator;

/**
 * Created by User on 07.05.2021.
 */
public class App {
    public static void main(String[] args) {
        ClassInProgram inProgram = new ClassInProgram(new ConsoleLogger());
        inProgram.action();

        inProgram.setLogger(new DateDecorator(new FileLogger("log1.txt")));
        inProgram.action();

        inProgram.setLogger(new CodeDecorator(new DateDecorator(new ConsoleLogger())));
        inProgram.action();
    }
}
