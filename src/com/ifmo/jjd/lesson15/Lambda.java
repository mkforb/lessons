package com.ifmo.jjd.lesson15;

import com.ifmo.jjd.lesson15.education.Calculators;
import com.ifmo.jjd.lesson15.education.Operation;

public class Lambda {
    public static void main(String[] args) {
        // Лямбда выражение. Работает только с функц. интерфейсом
        // double execute(double a, double b);
        Operation minus = (a, b) -> a - b; // Принимает на вход параметры a и b, делает вычисление и результат возвращается.
        // Переменные можно назвать по-другому, например, Operation minus = (x, y) -> x - y;
        // Внутри генерируется класс, который реализует интерфейс. minus - это объект этого класса.
        // Если метод принимает на вход один аргумент, круглые скобки можно не ставить. В остальных -- обязательно.
        // Стрелка обязательна между аргументами и телом метода.
        // Если тело метода -- это одна инструкция и метод возвращает какое-то значение, то не ставится не фигурных скобок, ни return.
        // Если тело метода -- это больше чем одна инструкция, фигурные скобки обязательны. Если метод должен что-то возвращать, то return надо писать явно.
        Operation div = (a, b) -> {
            if (b == 0) {
                System.out.println("Деление на 0 невозможно");
                return 0;
            }
            return a / b;
        };
        // Переменные minus и div могут быть локальными переменными, свойствами класса и их можно передавать в методы в качестве аргументов.
        System.out.println(minus.execute(10, 4));
        System.out.println(div.execute(5, minus.execute(10, 6)));

        System.out.println(Calculators.simpleOperation(2, 3, minus));
        System.out.println(Calculators.simpleOperation(3, 4, (a, b) -> a * b)); // Можно лямбду не сохранять в переменную, если не предполагается ее повторное использование.

    }
}
