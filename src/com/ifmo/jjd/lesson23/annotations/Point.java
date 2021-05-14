package com.ifmo.jjd.lesson23.annotations;

import com.ifmo.jjd.lesson24.validation.Max;
import com.ifmo.jjd.lesson24.validation.Min;

/**
 * Created by User on 12.05.2021.
 */
@Component(fileName = "point.properties", version = 2)
public class Point {
    @Required
    @Min(value = 10, errorMessage = "X < 10")
    @Max(value = 100, errorMessage = "Y > 100")
    private int x;
    @Required
    private int y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
