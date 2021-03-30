package com.ifmo.jjd.lesson7;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // Использование в массивах и коллекциях
        Knight knight = new Knight(20, 12);
        Infantry infantry = new Infantry(34, 5);

        BattleUnit bUnit1 = new Knight(8, 3); // У bUnit1 доступны свойства и методы BattleUnit, но свойства и методы Knight не теряются (хранятся в памяти). Они будут доступны после приведения типа
        BattleUnit bUnit2 = new Infantry(10, 7);

        Knight bKnight = (Knight) bUnit1; // Чтобы сузить тип данных, исп-ся приведение типа. Но если bUnit1 будет не типа Knight, приведение типов приведет к ошибке

        Unit unit = new King(34);

        // Когда заранее не известен тип данных
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите тип юнита");
        String type = scanner.nextLine();

        BattleUnit battleUnit;
        if ("knight".equals(type)) {
            battleUnit = new Knight(8, 3);
        } else {
            battleUnit = new Infantry(10, 7);
        }

        battleUnit.attack(infantry);

        System.out.println(battleUnit.getAttackScore());
    }
}
