package com.ifmo.jjd.lesson11.exceptions;

import java.io.IOException;

public class ExceptionsLesson {
    public static void main(String[] args) {
        int a = 33;
        int b = 0;
        // Перед выполнением деления сделать проверку на b <> 0
        // int res = a / b; // java.lang.ArithmeticException: / by zero

        int[] arr = new int[3];
        // arr[100] = 1; // java.lang.ArrayIndexOutOfBoundsException

        String string = null;
        // System.out.println(string.equals("")); // java.lang.NullPointerException

        Object data = "123";
        Integer integer1 = Integer.valueOf((String)data);
        // Integer integer = (Integer) data; // java.lang.ClassCastException

        // Обработка исключений
        Integer integer = null;
        try {
            integer = (Integer) data;
        } catch (ClassCastException e) {
            System.out.println("Обработка ClassCastException");
        }

        // Объединение блоков catch
        // Вариант 1: обработка по отдельности
        try {
            if (System.currentTimeMillis() % 2 == 0) integer = (Integer) data;
            else arr[100] = 1;
        } catch (ClassCastException e) {
            System.out.println("Обработка ClassCastException");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Обработка ArrayIndexOutOfBoundsException");
        }

        // Вариант 2: обработка несколько исключений вместе
        try {
            if (System.currentTimeMillis() % 2 == 0) integer = (Integer) data;
            else arr[100] = 1;
        } catch (ClassCastException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Обработка ClassCast или ArrayIndexOutOfBounds");
        }

        // Вариант 3:
        try {
            if (System.currentTimeMillis() % 2 == 0) integer = (Integer) data;
            else arr[100] = 1;
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            System.out.println("Обработка RuntimeException");
        } finally {
            // Блок finally выполнится всегда, независимо от исключений. Даже если будет исключение, которое не перехватывается
            // В finally обычно происходит закрытие ресурсов, которые открываются в блоке try
            // finally не нужен, если ресурсы открывались в круглых скобках после try
            System.out.println("Закрытие ресурсов, открытых try");
        }

        // Проверить данные до вызова метода, так как в случае некорректных данных программа остановится
        withUnCheckedException(34);

        try {
            // Проверяем имя файла перед тем, как подать в метод
            withCheckedException("some.bin");
        } catch (IOException e) {
            System.out.println("Обработка IOException");
            // Можно бросить еще exception, чтобы программа встала и мы поняли, где у нас есть ошибка
            throw new IllegalArgumentException(e.getMessage());
        }

        // Еще может быть такой вариант
        try {
            withCheckedException("some.tx");
        } catch (IOException ignored) {} // Пустые скобки - заглушка, чтобы компилятор не ругался

        // Когда программа не может фнкционировать без title и text, то нужно использовать исключение времени выполнения (?)
        Message message = new Message();
        try {
            message.setTitle("Срочное сообщение");
            message.setText("текст");
        } catch (AppException e) {
            e.printStackTrace();
            // Если throw new в блоке catch, то можно передать причину e
            throw new IllegalArgumentException("Ошибка валидации", e);
        }
    }

    public static void withUnCheckedException(int age) {
        if (age < 18) {
            // Генерация исключения времени выполнения
            throw new IllegalArgumentException("age < 18");
        }
        System.out.println("age = " + age);
    }

    public static void withCheckedException(String fileName) throws IOException {
        if (fileName.endsWith(".txt")) {
            // Генерация исключения времени компиляции
            throw new IOException("Ошибка файла");
        }
        System.out.println("fileName = " + fileName);
    }
}
