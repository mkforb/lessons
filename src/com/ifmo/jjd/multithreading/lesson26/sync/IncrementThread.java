package com.ifmo.jjd.multithreading.lesson26.sync;

/**
 * Created by User on 19.05.2021.
 */
public class IncrementThread extends Thread {
    private final Account account;

    public IncrementThread(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Синхронизированный метод
        // account.changeBalance(10);
        // При вызове synchronized метода объект account блокируется.
        // Другие потоки не смогут работать с объектом (даже вызывать не synchronized методы)
        // Очередность не соблюдается. Пока один поток работает с объектом, другие ждут
        // Один поток может продолжать работать с объектом, а другие так и будут ждать
        // synchronized - ресурсоемкая операция. Не ставить везде подряд

        // Синхронизированнй блок
        synchronized (account) { // В скобках объект, который должен блокироваться
            // Внутри {} описываем инструкции
            // Объект блокируется, пока не выполнятся инструкции в блоке synchronized
            // Один synchronized блок можно вкладывать в другой synchronized блок (чтобы заблокировать несколько объектов)
            // Очередность не соблюдается
            // Длительные вычисления, которые не свзяны с блокируемым объектом account, нужно помещать за блок synchronized
            account.changeBalance(10);
        }
    }
}
