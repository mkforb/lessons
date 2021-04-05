package com.ifmo.jjd.lesson10.enums;

import java.time.LocalDateTime;

public class Article {
    private final String title;
    private String text;
    private final LocalDateTime created;
    private Country country;

    public Article(String title) {
        this.title = title;
        created = LocalDateTime.now();
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    // Объявление перечисления
    public enum Country { // extends java.lang.Enum
        // Именуются как константы
        // Каждый элемент перечисления это объект указанного типа (Country)
        AUSTRALIA, UK, USA, GREAT_AND_BEAUTIFUL_RUSSIA
    }
}
