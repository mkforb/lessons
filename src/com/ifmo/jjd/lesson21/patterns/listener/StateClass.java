package com.ifmo.jjd.lesson21.patterns.listener;

import java.util.ArrayList;

/**
 * Created by User on 05.05.2021.
 */
public class StateClass {
    // В классе, за которым следят, создается список слушателей
    // Механизм подписки и отписки {
    private ArrayList<Listener> listeners = new ArrayList<>();
    public void addListener(Listener listener) {
        listeners.add(listener);
    }
    public void removeListener(Listener listener) {
        listeners.remove(listener);
    }
    // }

    private void lowNotify(int code) {
        // Если в классе происходит событие и объект считает, что нужно уведомить подписчиков
        listeners.forEach(listener -> listener.greenEvent(code));
    }

    private void mediumNotify(int code) {
        listeners.forEach(listener -> listener.yellowEvent(code));
    }

    private void highNotify(int code) {
        listeners.forEach(listener -> listener.redEvent(code));
    }

    public void changeState(String state) {
        if ("ok".equals(state)) lowNotify(1);
        if ("warn".equals(state)) mediumNotify(5);
        if ("error".equals(state)) highNotify(10);
    }
}
