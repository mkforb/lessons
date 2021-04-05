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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClimbingGroup)) return false;
        ClimbingGroup that = (ClimbingGroup) o;
        return Objects.equals(mountain, that.mountain) && Arrays.equals(climbers, that.climbers);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(mountain);
        result = 31 * result + Arrays.hashCode(climbers);
        return result;
    }

    @Override
    public ClimbingGroup clone() {
        ClimbingGroup copy = new ClimbingGroup(mountain.clone(), climbers.length);
        copy.climbers = climbers.clone();
        /*for (int i = 0; i < copy.climbers.length; i++) {
            copy.climbers[i] = climbers[i].clone();
        }*/
        return copy;
    }

    @Override
    public String toString() {
        return "ClimbingGroup{" +
                "mountain=" + mountain +
                ", climbers=" + Arrays.toString(climbers) +
                '}';
    }
}
