package com.ifmo.jjd.lesson10.enums;

import java.time.LocalDateTime;

public class Article {
    private String title;
    private String text;
    private LocalDateTime created;

    public Article(String title) {
        this.title = title;
        created = LocalDateTime.now();
    }
}
