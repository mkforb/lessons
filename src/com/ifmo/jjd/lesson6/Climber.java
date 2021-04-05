package com.ifmo.jjd.lesson6;

import java.util.Objects;
import java.util.UUID;

public class Climber {
    // Свойства (поля, атрибуты)
    // ToDo: Нужна ли начальная инициализация переменных?
    private String fullName;
    private int age;
    private String email;
    private UUID uuid;

    // Методы
    // Сеттеры - методы, которые устанавливают значения свойств объекта с проверками
    void setFullName(String fullName) {
        if (fullName == null || fullName.trim().length() < 3) {
            throw new IllegalArgumentException("Значение fullname < 3");
        }
        this.fullName = fullName;
    }

    /* package-private */
    void setAge(int age) {
        if (age < 18) {
            throw new IllegalArgumentException("Значение age < 18");
        }
        this.age = age; // this - это ссылка на текущий объект. Если имена переменных разные, то this можно не использовать
    }

    public void setEmail(String email) {
        // Принято сначала описать действия, если данные не валидны, а потом действия, которые надо выполнить, если данные валидны
        if (email == null || !email.trim().contains("@")) {
            throw new IllegalArgumentException("Это не email");
        }
        this.email = email;
    }

    public void setUuid() {
        // Здесь this можно не использовать
        uuid = UUID.randomUUID();
    }

    // Геттеры - методы, которые возвращают значения свойств объекта
    public String getFullName() {
        return fullName;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public UUID getUuid() {
        return uuid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Climber)) return false;
        Climber climber = (Climber) o;
        return age == climber.age && Objects.equals(fullName, climber.fullName) && Objects.equals(email, climber.email) && Objects.equals(uuid, climber.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, age, email, uuid);
    }

    @Override
    public Climber clone() {
        System.out.println("Climber copy");
        Climber copy = new Climber();
        return copy;
    }

    @Override
    public String toString() {
        return "Climber{" +
                "fullName='" + fullName + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", uuid=" + uuid +
                '}';
    }
}
