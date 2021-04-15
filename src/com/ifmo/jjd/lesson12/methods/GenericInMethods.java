package com.ifmo.jjd.lesson12.methods;

public class GenericInMethods {
    public static void main(String[] args) {
        String[] colors = {"red", "blue", "yellow"};
        Integer[] nums = {23, 545, 656};

        System.out.println(GenericUtils.inArray(colors, "red"));
        System.out.println(GenericUtils.<Integer>inArray(nums, 76)); // Можно конкретизировать тип через <Integer>. Тогда среда проверит, чтобы были переданы корректные данные. В данном случае можно не указывать

        int a = 23;
        double b = 500.56;
        System.out.println(GenericUtils.<Number, Number>compareNumbersHashCode(a, b)); // Поскольку дженерики не работают с примитивами, a и b автоупакуются в обертки
    }
}
