package com.ifmo.jjd.lesson9;

import com.ifmo.jjd.lesson6.Climber;

public class Application {
    public static void main(String[] args) {
        Object obj = new Climber(); // У obj будут доступны только методы класса Object

        Point a = new Point(45, 12);
        Point b = new Point(45, 12);
        System.out.println(a.equals(b)); // false, так как сравнивается ссылки // переопределили метод equals, теперь возвр. true

        Point c = a.clone();
        System.out.println(c == a); // false
        System.out.println(c.equals(a)); // true

        Figure first = new Figure(2);
        first.addPoint(a);
        first.addPoint(b);

        Figure second = first.clone();

        System.out.println(first);
        System.out.println(second);
    }
}
