package com.ifmo.jjd.lesson23.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by User on 12.05.2021.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Component {
    // Аннотация может быть пустой, а может быть с параметрами
    // В качестве параметров можно использовать строки, примитивы, перечисления
    String fileName();
    long version() default 1; // Значение по умолчанию 1
    // При исп-ии аннотации нужно обязательно указывать значения параметров, у которых нет default значения
}
