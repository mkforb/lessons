package com.ifmo.jjd.lesson12.methods;

public class GenericUtils {
    //public static boolean inArray(String[] arr, String elem) { }

    //public static boolean inArray(int[] arr, int elem) { }

    public static <T> boolean inArray(T[] arr, T elem) { // Одна буква значит один тип данных. Может быть любая буква, обычно заглавная
        // <T> перед boolean говорит, что метод будет принимать дженерик-тип
        // В методе не можем вызывать у elem никаких методов, кроме методов класса Object
        for (T t : arr) {
            if (t.equals(elem)) return true;
        }
        return false;
    }

    public static <T extends Number, K extends Number> int compareNumbersHashCode(T first, K second) { // Два разных дженерик-типа T и K
        // extends Number говорит, что first и second могут быть Number или их потомками
        // В данном случае, поскольку указано extends Number, у first и second можно вызывать методы Number
        return Integer.compare(first.hashCode(), second.hashCode());
    }
}
