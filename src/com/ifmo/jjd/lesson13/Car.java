package com.ifmo.jjd.lesson13;

import java.util.Comparator;

public class Car {
    private String color;
    private String brand;
    private int price;

    public Car(String color, String brand, int price) {
        this.color = color;
        this.brand = brand;
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                ", brand='" + brand + '\'' +
                ", price=" + price +
                '}';
    }

    public static class ColorComparator implements Comparator<Car> {
        @Override
        public int compare(Car o1, Car o2) {
            return o1.color.compareTo(o2.color);
        }
    }

    public static class BrandComparator implements Comparator<Car> {
        @Override
        public int compare(Car o1, Car o2) {
            return o1.brand.compareTo(o2.brand);
        }
    }

    public static class PriceComparator implements Comparator<Car> {
        @Override
        public int compare(Car o1, Car o2) {
            return Integer.compare(o1.price, o2.price);
        }
    }

    public static class CarComparator implements Comparator<Car> {
        @Override
        public int compare(Car o1, Car o2) {
            int res = Integer.compare(o1.price, o2.price);
            if (res != 0) {
                return res;
            }
            res = o1.color.compareTo(o2.color);
            if (res != 0) {
                return res;
            }
            return o1.brand.compareTo(o2.brand);
        }
    }
}