package com.ifmo.jjd.lesson24.validation;

import com.ifmo.jjd.lesson23.annotations.Point;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by User on 14.05.2021.
 */
public class App {
    public static void main(String[] args) {
        Point point = new Point();
        point.setX(5);
        point.setY(200);

        Validator<Point> validator = new Validator<>(point);
        validator.validate();
        validator.getErrors().forEach(System.out::println);
    }
}
