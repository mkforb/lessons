package com.ifmo.jjd.lesson15;

import java.util.function.Function;
import java.util.function.Predicate;

public class EmbeddedFunctionalInterface {
    public static void main(String[] args) {
        // Функц. интерфейсы в основном лежат в пакете java.util.function

        // boolean test(T t);
        // Проверка на положительное число
        // Проверка на отрицательное число
        // Проверка на четное число
        Predicate<Integer> isPositive = t -> t > 0;
        Predicate<Integer> isNegative = t -> t < 0;
        Predicate<Integer> isEven = t -> t % 2 == 0;

        System.out.println(isPositive.test(-2));
        System.out.println(isNegative.test(-2));
        System.out.println(isEven.test(3));

        // Если метод принимает на вход функц. интерфейс, надо сначала посмотреть на этот интерфейс, что он принимает на вход

        System.out.println(isPositive.and(isEven).test(8)); // Проверяем на положительность и четность одновременно (логическое И)
        System.out.println(isPositive.or(isEven).test(5)); // Логическое ИЛИ
        System.out.println(isNegative.negate().test(4)); // Отрицание

        // R apply(T t);
        Function<Integer, Integer> sqrt = x -> x * x;
        System.out.println(sqrt.apply(3)); // 9
        Function<Integer, String> convert = x -> x + "RUB";
        System.out.println(convert.apply(45)); // 45RUB
        // У Function есть метод apply, который принимает объект одного типа, а возвращает другой.
        // Это обычное использование этого интерфейса. Но можно принимать и возвращать одного типа.

        // Посмотреть ИФ BiFunction, Consumer, BiConsumer, Comparator
    }
}
