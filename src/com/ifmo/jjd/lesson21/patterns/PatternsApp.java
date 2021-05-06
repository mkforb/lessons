package com.ifmo.jjd.lesson21.patterns;

import com.ifmo.jjd.lesson21.patterns.builder.NutritionFacts;
import com.ifmo.jjd.lesson21.patterns.listener.Listener;
import com.ifmo.jjd.lesson21.patterns.listener.StateClass;

import java.util.Scanner;

/**
 * Created by User on 05.05.2021.
 */
public class PatternsApp {
    public static void main(String[] args) {

        // Builder
        NutritionFacts apple = new NutritionFacts.Builder(3) // в конструктор передаются обязательные параметры
                .calories(100) // устанавливаются необязательные параметры
                .fat(3)
                .build(); // возвращается объект

        // Listener
        // Наблюдатели
        // Если есть абстрактный класс или ИФ, то для создания объектов можно воспользоваться синтаксисом анонимных классов:
        Listener listener1 = new Listener() {
            @Override
            public void greenEvent(int code) {
                System.out.println("listener1 greenEvent " + code);
            }

            @Override
            public void yellowEvent(int code) {
                System.out.println("listener1 yellowEvent " + code);
            }

            @Override
            public void redEvent(int code) {
                System.out.println("listener1 redEvent " + code);
            }
        };

        Listener listener2 = new Listener() {
            @Override
            public void greenEvent(int code) {
                System.out.println("listener2 greenEvent " + code);
            }

            @Override
            public void yellowEvent(int code) {
                System.out.println("listener2 yellowEvent " + code);
            }

            @Override
            public void redEvent(int code) {
                System.out.println("listener2 redEvent " + code);
            }
        };

        StateClass stateClass = new StateClass();
        stateClass.addListener(listener1);
        stateClass.addListener(listener2);

        Scanner scanner = new Scanner(System.in);
        String state;
        while (true) {
            System.out.println("Введите статус:");
            state = scanner.nextLine();
            if ("exit".equals(state)) break;
            stateClass.changeState(state);
        }
    }
}
