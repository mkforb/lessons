package com.ifmo.jjd.lesson12.types.parameters;

class BusGarage extends Garage {
    void checkBus() {
        // this.getCarOnService() вернет Transport, так как Garage<T extends Transport>
        // Лучше указывать конкретно тип, например, Garage<Transport>
        System.out.println(this.getCarOnService().getNum());
    }
}

class TrainGarage extends Garage<Train> {
    void checkTrain() {
        // this.getCarOnService() вернет Train, так как TrainGarage extends Garage<Train>
        System.out.println(this.getCarOnService().getCarCount());
    }
}

class TransportGarage extends Garage<Transport> {
    void checkTrain() {
        // this.getCarOnService() вернет Transport, так как TransportGarage extends Garage<Transport>
        System.out.println(this.getCarOnService());
    }
}
