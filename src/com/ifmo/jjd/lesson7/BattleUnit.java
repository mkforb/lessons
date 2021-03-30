package com.ifmo.jjd.lesson7;

abstract public class BattleUnit extends Unit implements AttackAble {
    // Unit - родительскиц или суперкласс
    // BattleUnit - дочерний или подкласс
    // Наследование от нескольких классов не допускается
    private int attackScore;

    public BattleUnit(int healthScore, int attackScore) {
        super(healthScore); // Вызов конструктора родителя
        this.attackScore = attackScore;
    }

    public int getAttackScore() {
        return attackScore;
    }
}
