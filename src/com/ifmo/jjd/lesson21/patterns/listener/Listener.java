package com.ifmo.jjd.lesson21.patterns.listener;

/**
 * Created by User on 05.05.2021.
 */
public interface Listener {
    // Объекты, которые следят, должны реализовывать этот интерфейс
    void  greenEvent(int code);
    void  yellowEvent(int code);
    void  redEvent(int code);
}
