package com.ifmo.jjd.lesson6;

import java.util.Arrays;
import java.util.Objects;

public class ClimbingGroup {
    private Mountain mountain;
    private Climber[] climbers;

    public ClimbingGroup(Mountain mountain, int climberCount) {
        // Проверка на null + исключение
        this.mountain = Objects.requireNonNull(mountain, "mountain не может быть null");
        climbers = new Climber[climberCount];
    }

    public void addClimber(Climber climber) {
        Objects.requireNonNull(climber, "climber не может быть null");
        for (int i = 0; i < climbers.length; i++) {
            if (climbers[i] == null) {
                climbers[i] = climber;
                return; // В void методах исп-ся для завершения работы метода
            }
        }
        System.out.println("Мест нет");
    }

    public void addClimber(Climber... climbers) {
        // ToDo
    }

    @Override
    public String toString() {
        return "ClimbingGroup{" +
                "mountain=" + mountain +
                ", climbers=" + Arrays.toString(climbers) +
                '}';
    }
}
