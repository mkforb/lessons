package com.ifmo.jjd.lesson21;

/**
 * Created by User on 05.05.2021.
 */
public class User {
    private Level level;
    private String login;

    public User(Level level, String login) {
        this.level = level;
        this.login = login;
    }

    // Без static - внутренний класс (inner class)
    // Область видимости - согласно модификатору доступа
    // Не могут содержать стат. поля и методы, кроме final
    // Имеют доступ ко всем полям и методам внешнего класса
    // Нельзя создать объект внутреннего класса, пока не создан объект внешнего класса
    public class Account {
        public static final double MAX_BALANCE = 1000;
        private double balance;

        public Account(double balance) {
            // Обращение к своействам внешнего класса
            // <имя внешнего класса>.this.<имя свойства>
            this.balance = User.this.level.getCount();
        }

        public User getUser() {
            // Ссылка на объект внешнего класса
            return User.this;
        }
    }

    // Вложенный
    public enum Level {
        HIGH(100), MEDIUM(50), LOW(10);

        private double count;

        Level(double count) {
            this.count = count;
        }

        public double getCount() {
            return count;
        }
    }
}
