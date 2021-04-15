package com.ifmo.jjd.lesson13;

import java.util.*;

public class CarComparing {
    public static void main(String[] args) {

        // сортировать по значениям свойств: price, color, brand
        Car blackOpel = new Car("black", "opel", 2000);
        Car redOpel = new Car("red", "opel", 2500);
        Car yellowMazda = new Car("yellow", "mazda", 3000);
        Car greenMazda = new Car("green", "mazda", 3000);

        //Comparator<Car> comparator = new Car.PriceComparator().thenComparing(new Car.ColorComparator()).thenComparing(new Car.BrandComparator());
        Comparator<Car> comparator = new Car.CarComparator();
        TreeSet<Car> carTreeSet = new TreeSet<>(comparator);
        carTreeSet.addAll(Arrays.asList(blackOpel, redOpel, yellowMazda, greenMazda));
        System.out.println(carTreeSet);
    }
}