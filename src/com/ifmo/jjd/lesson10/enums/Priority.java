package com.ifmo.jjd.lesson10.enums;

public enum Priority {
    // Перечисление Priority могут быть в нескольких класса, поэтому его выносим в отдельный файл
    // Перечисление Article.Country -- только у класса Article, поэтому он внутри класса Article
    // Если после перечисления будет что-то еще, то после перечисления ставиться точка с запятой
    // Если перечислений много, то их перечисляют в столбик
    HIGH(10), MIDDLE(5), LOW(1);

    private int code;

    Priority(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
