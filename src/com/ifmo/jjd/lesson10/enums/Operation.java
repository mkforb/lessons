package com.ifmo.jjd.lesson10.enums;

public enum Operation {
    // Методы в перечислениях
    // Нужно объявить абстрактный класс и реализовать его в каждом элементе
    SUM {
        @Override
        public int action(int a, int b) {
            return a + b;
        }
    },

    MULTI {
        @Override
        public int action(int a, int b) {
            return a * b;
        }
    };

    public abstract int action(int a, int b);

}
