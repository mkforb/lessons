package com.ifmo.jjd.lesson6;

public class Mountain {
    // Принято описывать в такой последовательности:
    // Свойства
    // Конструкторы
    // Сеттеры и геттеры
    // Собственные методы класса
    // Переопределнные методы

    private String name;
    private int height;

    // Конструктор - то, что вызывается, когда создается объект
    public Mountain() {
        // Вызов конструктора
        this("Гора по умолчанию", 300);
    }

    public Mountain(String name, int height) {
        setName(name);
        setHeight(height);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (name == null || name.trim().length() < 2) {
            throw new IllegalArgumentException("name < 2");
        }
        this.name = name;
    }

    public int getHeight() {
        return height;
    }

    private void setHeight(int height) {
        if (height < 100) {
            throw new IllegalArgumentException("height < 100");
        }
        this.height = height;
    }

    @Override
    public String toString() {
        return "Mountain{" +
                "name='" + name + '\'' +
                ", height=" + height +
                '}';
    }
}
