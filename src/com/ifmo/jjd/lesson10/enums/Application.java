package com.ifmo.jjd.lesson10.enums;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        Article auArticle = new Article("Про Австралию");
        auArticle.setText("текст статьи");
        auArticle.setCountry(Article.Country.AUSTRALIA);

        Article ukArticle = new Article("Про Британию");
        ukArticle.setText("текст статьи");
        ukArticle.setCountry(Article.Country.UK);

        // Методы Enum
        // Массив элементов перечисления
        Article.Country[] countries = Article.Country.values();
        System.out.println(Arrays.toString(countries));

        // Индекс элемента перечисления
        System.out.println(Article.Country.USA.ordinal()); // 2

        // Если элементы массива менять не надо, используем цикл foreach (кратко вызвать: iter)
        for (Article.Country country : countries) {
            System.out.println(country.ordinal() + " " + country.name());
        }

        Article.Country usa = Article.Country.valueOf("USA"); // valueOf принимает строку, возвращает объект перечисления Article.Country
        System.out.println(usa);

        Priority priority = Priority.HIGH; // Получили ссылку на существующий объект. Сам объект создается внутри класса Priority
        priority.setCode(100);
        System.out.println(priority.getCode());

        Priority.MIDDLE.setCode(50);
        System.out.println(Priority.MIDDLE.getCode());

        for (Priority elem : Priority.values()) {
            System.out.println(elem.name() + " " + elem.getCode());
        }

        // Сравнение перечислений через ==, потому что кол-во объектов фиксированное
        if (priority == Priority.HIGH) {
            System.out.println("Срочное сообщение");
        } else if (priority == Priority.LOW) {
            System.out.println("Не очень срочное сообщение");
        }

        Operation sum = Operation.SUM;
        System.out.println(sum.action(5, 5));

        System.out.println(Operation.MULTI.action(5, 5));

        // Создать enum, который перечисляет планеты солнечной системы
        // должна быть реализована возможность узнать массу и радиус каждой планеты
        // Значения вывести в цикле

        for (Planet planet : Planet.values()) {
            System.out.println(planet.name() + ": масса " + planet.getMass() + ", радиус " + planet.getRadius());
        }

    }
}
