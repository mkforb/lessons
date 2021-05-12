package com.ifmo.jjd.lesson23.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by User on 12.05.2021.
 */
// @Target - где используется
// @Retention - когда
@Target({ElementType.FIELD, ElementType.METHOD}) // Значит что аннотацию можно испольхзовать с полями и с методами
@Retention(RetentionPolicy.RUNTIME) // во время выполнения
public @interface Required {
}
