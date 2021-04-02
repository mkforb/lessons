package com.ifmo.jjd.lesson7;

// Статический импорт позволяет импортировать статический метод или статическое свойство
//import static com.ifmo.jjd.lesson7.Settings.GOLD_COUNT;
import com.ifmo.jjd.lesson7.utils.Randoms;

import static com.ifmo.jjd.lesson7.Settings.*;

final public class King extends Unit {
    private int gold = GOLD_COUNT;
    private BattleUnit[] army; // В массив можно добавлять не только BattleUnit, но и всех его наследников
                               // Методы и свойства будут доступны только от родителя, т.е. от BattleUnit

    public King() {
        super(KING_HEALTH);
        generateArmy();
    }

    // Стоимость армии 200
    private void generateArmy() {
        army = new BattleUnit[ARMY_COUNT];
        if (gold < ARMY_PRICE) return;
        for (int i = 0; i < army.length; i++) {
            army[i] = BattleUnit.getBattleUnit();
        }
        minusGold(ARMY_PRICE);
    }

    // Стоимость каждого юнита 20
    public void addUnits() {
        for (int i = 0; i < army.length; i++) {
            if (army[i].isAlive()) continue;
            if (gold < UNIT_PRICE) return;
            army[i] = BattleUnit.getBattleUnit();
            minusGold(UNIT_PRICE);
        }
    }

    public void startBattle(King enemy) {
        // В цикле
        // 1. Рандомный юнит армии короля атакует рандомного юнита из армии противника
        // 2. Рандомный юнит армии противника атакует рандомного юнита из армии короля
        // После атаки у юнитов вызывается метод rest().
        // Юниты с 0 здоровьем не должны атаковать
        // Юнитов с 0 здоровьем нельзя атаковать
        for (int i = 0; i < 10; i++) {
            int thisIndex = Randoms.getRandomInt(army.length);
            int enemyIndex = Randoms.getRandomInt(enemy.army.length);
            if (!army[thisIndex].isAlive() || !enemy.army[enemyIndex].isAlive()) continue;
            army[thisIndex].attack(enemy.army[enemyIndex]);
            army[thisIndex].rest();
            if (!army[thisIndex].isAlive() || !enemy.army[enemyIndex].isAlive()) continue;
            enemy.army[enemyIndex].attack(army[thisIndex]);
            enemy.army[enemyIndex].rest();
        }
    }

    // Вернуть кол-во живых юнитов
    public int getAliveCount() {
        int count = 0;
        for (int i = 0; i < army.length; i++) {
            if (army[i].isAlive()) count++;
        }
        return count;
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
