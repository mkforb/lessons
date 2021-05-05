package com.ifmo.jjd.lesson20;

import java.nio.ByteBuffer;

public class NIOBuffer {
    public static void main(String[] args) {
        // capacity - емкость (не меняется после установки)
        // position - текущая позиция в буфере (изначально 0)
        // limit - до какого значения можно читать / писать данные (изначально равен capacity)
        ByteBuffer buffer = ByteBuffer.allocate(16); // В скобках размер. Всегда создается с заданной емкостью
        assert buffer.position() == 0;
        assert buffer.capacity() == 16;
        assert buffer.limit() == 16;
        assert buffer.remaining() == 16;

        buffer.putInt(100); // Добавляем в буфер 100, position меняется на 4 (потому что int - это 4 байта)

        assert buffer.position() == 4;
        assert buffer.remaining() == 12;

        buffer.putDouble(100.25); // Добавляем Double, position = 12

        assert buffer.position() == 12;
        assert buffer.remaining() == 4;

        buffer.flip(); // Перемещает limit на место position, position перемещает в 0.
        // flip используется для подготовки буфера для чтения

        assert buffer.position() == 0;
        assert buffer.limit() == 12;
        assert buffer.remaining() == 12;

        int anInt = buffer.getInt();

        assert buffer.position() == 4;
        assert buffer.remaining() == 8;

        double aDouble = buffer.getDouble();

        assert buffer.position() == 12;
        assert buffer.remaining() == 0;

        buffer.rewind(); // Подготавливает буфер к повторному чтению. limit остается на прежнем месте, position - в 0

        assert buffer.position() == 0;
        assert buffer.limit() == 12;
        assert buffer.remaining() == 12;

        assert anInt == buffer.getInt();
        assert aDouble == buffer.getDouble();

        buffer.clear(); // Ничего из буфера не удаляет, а limit перемещает в capacity, position в 0

        assert buffer.position() == 0;
        assert buffer.capacity() == 16;
        assert buffer.limit() == 16;
        assert buffer.remaining() == 16;

        buffer.compact(); // Все непрочитанные байты копируются в начало буфера. limit устанавливается к capacity
        // assert используется при разработке
        // Чтобы включить assert, нужно передать VM options -ea
        // С помощью него проверяем утверждения
        // Если утверждение не выполнится, то программа остановится с ошибкой

    }
}
