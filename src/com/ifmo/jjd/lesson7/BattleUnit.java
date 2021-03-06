package com.ifmo.jjd.lesson7;

import com.ifmo.jjd.lesson7.utils.Randoms;

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

    public static BattleUnit getBattleUnit() {
        String[] types = {"knight", "infantry"};
        BattleUnit unit = null;
        switch (types[Randoms.getRandomInt(types.length)]) {
            case "knight":
                unit = new Knight(Randoms.getRandomInt(10, 30), Randoms.getRandomInt(10, 50));
                break;
            case "infantry":
                unit = new Infantry(Randoms.getRandomInt(10, 60), Randoms.getRandomInt(10, 40));
                break;
        }
        return unit;
    }
}
