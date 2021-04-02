package com.ifmo.jjd.lesson7;

abstract public class Unit implements RestAble {
    // implements означает, что класс имплементирует или реализаует интерфейс
    // Класс может имплементировать сколько угодно интерфейсов
    // Интерфейс обязывает класс реализовать все абстрактные методы, в нем перечисленные, на усмотрение класса
    protected int healthScore;
    protected final int maxHealthScore;

    public Unit(int healthScore) {
        this.healthScore = healthScore;
        maxHealthScore = healthScore;
    }

    public boolean isAlive() {
        return healthScore > 0;
    }

    public void plusHealth(int count) {
        if (!isAlive()) return;
        healthScore = Math.min(healthScore + count, maxHealthScore);
    }

    public void minusHealth(int count) {
        if (!isAlive()) return;
        healthScore -= count;
    }
}
