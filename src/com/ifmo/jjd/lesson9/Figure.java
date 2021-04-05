package com.ifmo.jjd.lesson9;

import java.util.Arrays;

public class Figure {
    private Point[] points;

    public Figure(int pointsCount) {
        this.points = new Point[pointsCount];
    }

    public void addPoint(Point point) {
        for (int i = 0; i < points.length; i++) {
            if (points[i] == null) {
                points[i] = point;
                return;
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Figure)) return false;
        Figure figure = (Figure) o;
        return Arrays.equals(points, figure.points);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(points);
    }

    @Override
    public Figure clone() {
        // В реализации clone() можно создавать улучшенную копию, с отличными от оригинала свойствами
        // Если не используем super.clone(), то имплементация Cloneable не нужна
        Figure copy = new Figure(points.length);
        copy.points = points.clone();
        return copy;
    }

    @Override
    public String toString() {
        return "Figure{" +
                "points=" + Arrays.toString(points) +
                '}';
    }
}
