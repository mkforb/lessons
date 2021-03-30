package com.ifmo.jjd.lesson7;

public class King extends Unit {
    private int gold = 600;
    private BattleUnit[] army; // В массив можно добавлять не только BattleUnit, но и всех его наследников
                               // Методы и свойства будут доступны только от родителя, т.е. от BattleUnit

    public King(int healthScore) {
        super(healthScore);
    }

    private boolean hasGold() {
        return gold > 0;
    }

    private void plusGold(int count) {
        gold += count;
    }

    private void minusGold(int count) {
        if (!hasGold()) return;
        gold -= count;
    }


    @Override
    public void rest() {
        minusGold(50);
        plusHealth(10);
    }
}
