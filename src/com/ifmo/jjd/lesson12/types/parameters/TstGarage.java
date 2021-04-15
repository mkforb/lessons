package com.ifmo.jjd.lesson12.types.parameters;

public class TstGarage {
    public static void main(String[] args) {
        Bus bus = new Bus("Спб", "Тверь", "234", false);
        Train train = new Train("Спб", "Москва", "23-Ф", 12);

        // public class Garage<T extends Transport>
        Garage<Bus> busGarage = new Garage<>();
        busGarage.setCarOnService(bus);
        System.out.println(busGarage.getCarOnService().isWiFi());

        Garage<Transport> transportGarage = new Garage<>();
        transportGarage.setCarOnService(bus); // Можно передать любого наследника Transport
        transportGarage.setCarOnService(train);
        transportGarage.getCarOnService().repair(); // Объекту transportGarage.getCarOnService() будут доступны только методы Transport

        Train fromGarage = (Train) transportGarage.getCarOnService();
        System.out.println(fromGarage.getCarCount()); // После привидения типов доступны методы Train
    }
}