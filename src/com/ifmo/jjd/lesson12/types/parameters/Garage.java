package com.ifmo.jjd.lesson12.types.parameters;

// public class Garage<T extends Transport & Repairing & Cloneable> // может быть типа Transport или его наследниками, которые реализуют интерфейс Repairing и Cloneable, интерфейсов можно перечислить несколько, класс должен реализовывать все перечисленные интерфейсы
// public class Garage<T extends Repairing & Cloneable> // можно указать только интерфейсы

public class Garage<T extends Transport> {
    private T carOnService; // carOnService может быть типа Transport или его наследниками

    public void service() {
        carOnService.repair();
    }

    public T getCarOnService() {
        return carOnService;
    }

    public void setCarOnService(T carOnService) {
        this.carOnService = carOnService;
    }
}
