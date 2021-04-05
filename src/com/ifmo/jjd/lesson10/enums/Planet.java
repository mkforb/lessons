package com.ifmo.jjd.lesson10.enums;

public enum Planet {
    MERCURY(3.3 * Math.pow(10, 23), 2439),
    VENUS(4.9 * Math.pow(10, 24), 6051),
    EARTH(6 * Math.pow(10, 24), 6371),
    MARS(6.4 * Math.pow(10, 23), 3389),
    JUPITER(2 * Math.pow(10, 27), 69911),
    SATURN(5.7 * Math.pow(10, 26), 58232),
    URANUS(8.7 * Math.pow(10, 25), 25362),
    NEPTUNE(1 * Math.pow(10, 26), 24622);

    private final double mass;
    private final int radius;

    Planet(double mass, int radius) {
        this.mass = mass;
        this.radius = radius;
    }

    public double getMass() {
        return mass;
    }

    public int getRadius() {
        return radius;
    }
}
