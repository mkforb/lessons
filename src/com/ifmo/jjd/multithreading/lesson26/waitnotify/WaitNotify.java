package com.ifmo.jjd.multithreading.lesson26.waitnotify;

/**
 * Created by User on 19.05.2021.
 */
public class WaitNotify {
    public static void main(String[] args) {
        // wait() - освобождает монитор объекта и переводит поток в ожидание до тех пор, пока он не будет "разбужен" методом notify() в другом потоке. На практике поток может сам пробудиться и продолжить работать.
        // wait(mls) - то же, только ждет максимум mls милисекунде, после проснется сам
        // notify() - будит случайный поток, который был приостановлен методом wait()
        // notifyAll() - будит все потоки, которые были приостановлены методом wait()
        // Их можно вызвать из синхронизированного блока или метода
        Library library = new Library();
        new Thread(new PutThread(library)).start();
        new Thread(new GetThread(library)).start();
    }
}
