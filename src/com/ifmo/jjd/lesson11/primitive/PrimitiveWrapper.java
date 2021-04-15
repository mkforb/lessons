package com.ifmo.jjd.lesson11.primitive;

public class PrimitiveWrapper {
    public static void main(String[] args) {
        // byte - class Byte
        // short - class Short
        // int - class Integer
        // long - class Long
        // boolean - class Boolean
        // float - class Float
        // double - class Double
        // char - class Character
        // У каждого примитива есть соот-щий класс обертки
        // Класс обертки надо использовать:
        // 1. если использование примитивов невозможно
        // 2. если надо воспользоваться методами обертки
        // Во всех остальных случаях использовать примитив

        int count = 3421;
        Integer age = 56; // new Integer(56); -- такой вариант не используется, он устаревший. Это относится ко всем классам обертки

        // Автоупаковка и автораспаковка
        // Автоупаковка
        Integer i = 3345; // Integer i = count;
        // Автораспаковка
        Double d = 67.9;
        double price = d;

        // Автоупаковка и автораспаковка не работает с массивами
        double[] doubles = {34.54, 65.4};
        //printArr(doubles); // Такое нельзя!

        // Автоупаковка не будет работать если примитив не соот-ет классу обертки
        byte byteVar = 1;
        // Integer integerVar = byteVar; // Не работает!
        Integer integerVar = (int) byteVar; // Сначала делаем привидение, потом автоупаковку

        // А автораспаковка работать будет соот-но размерам контейнера

        // Сравнение целочисленных значений
        // Значения [-127; 128]
        Long first = 45L;
        Long second = 45L;
        System.out.println(first == second); // true, потому что значения попадают в диапазон [-127; 128]. В этом случае они кэшируются (аналогично как пул строк)
        System.out.println(first.equals(second)); // true, потому что сравнение через equals

        Long third = 200L;
        Long fourth = 200L;
        System.out.println(third == fourth); // false, потому что разные ссылки
        System.out.println(third.equals(fourth)); // true, потому что сравнение через equals

        Integer a = 78;
        Integer b = 78;
        System.out.println(a.compareTo(b));
        System.out.println(Integer.compare(a, b));

        System.out.println(Integer.hashCode(a)); // hashcode числа = само число

        // Возвращают примитив
        System.out.println(a.longValue());
        System.out.println(a.intValue());
        System.out.println(a.shortValue());
        System.out.println(a.floatValue());
        System.out.println(a.doubleValue());
        System.out.println(a.byteValue());

        // Преобразовать строку в число
        // parseXXX(строка_с_числом); XXX - тип данных, -- возвр. примитив
        // valueOf(строка_с_числом); -- возвр. объект
        long l = Long.parseLong("45");
        Short s = Short.valueOf("22");
        Float f = Float.valueOf("344.43");
        // NumberFormatException если строка содержит не только числа

        System.out.println(Integer.min(3, 30));
        System.out.println(Integer.max(3, 30));
        System.out.println(Integer.sum(34, 56));

        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);

        System.out.println(Double.MIN_VALUE);
        System.out.println(Double.MAX_VALUE);
        System.out.println(Double.NEGATIVE_INFINITY);
        System.out.println(Double.POSITIVE_INFINITY);
        System.out.println(Double.isInfinite((double) 9/0));
    }

    private static void printArr(Double[] doubles) {
        for (Double aDouble : doubles) {
            System.out.println(aDouble);
        }
    }
}
