package com.ifmo.jjd.lesson21.patterns.builder;

/**
 * Created by User on 05.05.2021.
 */
public class NutritionFacts {
    // Builder - это отдельный класс, который создает объекты нужного нам типа
    // Обязательные параметры
    private final int servings;
    // Необязательные параметры
    private final int calories;
    private final int fat;

    // Конструктор внешнего класса делаем приватным, если есть билдер
    private NutritionFacts(Builder builder) {
        servings = builder.servings;
        calories = builder.calories;
        fat = builder.fat;
    }

    public static class Builder {
        // Вложенный класс будет создавать объекты класса NutritionFacts
        // Дублируются обязательные параметры. Отмечаем их final
        private final int servings;
        // Необязательные параметры инициализируются со значениями по умолчанию. Они здесь без final
        private int calories = 1;
        private int fat; // 0

        // Значения обязательных параметров передаются в конструкторе
        public Builder(int servings) {
            this.servings = servings;
        }

        // Для необязательных пишем аналог сеттеров
        public Builder calories(int count) {
            calories = count;
            return this;
        }

        public Builder fat(int count) {
            fat = count;
            return this;
        }

        // Метод, который возвращает объект внешнего класса
        public NutritionFacts build() {
            return new NutritionFacts(this);
        }
    }
}
