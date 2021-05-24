package com.ifmo.jjd.multithreading.lesson28;

import java.util.concurrent.Exchanger;

/**
 * Created by User on 24.05.2021.
 */
public class ExchangerExample {
    public static void main(String[] args) {
        // Класс Exchanger предназ. для обмена данными между двумя потоками
        // В дженерике указ. тип данных, которыми обмениваются потоки
        // Один поток кладет данные в exchanger. Другой поток берет данные и взамен кладет данные
        // Оба потока ссылаются на один exchanger
        Exchanger<String> exchanger = new Exchanger<>();
        new Thread(() -> {
            try {
                System.out.println("Первый поток получил данные " + exchanger.exchange("Первый"));
                // В метод exchange() передаем то, что поток должен передать другому потоку
                // А возвращает то, что получает от другого потока
                // Если поток хочет передать данные, а в обменнике ничего нет, то поток будет заблокирован до тех пор, пока в обменнике не появятся данные
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                System.out.println("Второй поток получил данные " + exchanger.exchange("Второй"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
