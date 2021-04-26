package com.ifmo.jjd.lesson18.handlers;

import java.io.*;
import java.util.Scanner;

/**
 * Created by User on 26.04.2021.
 */
public class TxtHandler extends FileHandler { // .txt

    public TxtHandler(File file) {
        setFile(file);
    }

    public void setFile(File file) {
        if (file == null || !file.getName().endsWith("txt") || file.isDirectory()) {
            this.file = new File("default.txt");
        } else {
            this.file = file;
        }
        try {
            if (this.file.createNewFile()) { // createNewFile() создает файл. Возвр. true, если файла не было и он создался. false - если не создал
                System.out.println(this.file.getName() + " создан");
            } else {
                System.out.println(this.file.getName() + " уже существует");
            }
        } catch (IOException e) {
            System.out.println("Файл не был создан " + e.getMessage());
        }
    }

    public boolean writeFromConsole() {
        boolean result = false;
        try (FileOutputStream fileOutputStream = new FileOutputStream(file, true);
                BufferedOutputStream buffer = new BufferedOutputStream(fileOutputStream)) {

            // Все, что наследуется от FilterOutputStream или FilterInputStream -- классы обертки или декораторы, это дополнение к основному функционалу
            // Они не передают данные, только преобразование
            // Данные сначала накапливаются в буфере. Если с ними ничего не сделать, они там и останутся
            // Когда буфер заполнен, BufferOutputStream передает данные в FileOutputStream, который запишет их в файл
            // Все наследники FilterOutputStream принимают на вход какой-нибудь OutputStream
            // Все наследники FilterInputStream принимают на вход InputStream
            // программа -> decorator -> outputStream
            // программа <- decorator <- inputStream
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("Введите данные или stop для выхода");
                String userInput = scanner.nextLine();
                if (userInput.equals("stop")) break;
                buffer.write((userInput+"\n").getBytes()); // buffer копит данные. Когда накопит, передает в fileOutputStream
            }
            result = true;
        } catch (FileNotFoundException e) {
            System.out.println("Файл не удалось найти");
        } catch (IOException e) {
            System.out.println("Ошибка записи в файл");
        }
        return result;
    }

    @Override
    public boolean writeToFile(byte[] data) {
        boolean result = false;
        // try with resources. В скобках создается объект. Если создается несколько объектов, то ставим точку с запятой.
        // Можно создавать любые объекты, классы которых имплем. ИФ AutoCloseable.
        // ИФ AutoCloseable обязывает реализовать метод close.
        // Когда инструкции блока try завершатся или будет выброшено исключение,
        // у созданных в скобках объектов вызывается метод close.
        try (FileOutputStream outputStream = new FileOutputStream(file, true)) {
            // true -- будет дозапись в конец файла, не затирает
            // false -- перезапись
            outputStream.write(data);
            result = true;
        } catch (FileNotFoundException e) {
            // Если файла нет
            System.out.println("Файл для записи не был найден");
        } catch (IOException e) {
            System.out.println("Ошибка записи в файл");
        }
        return result;
    }

    @Override
    public byte[] readFromFile() {
        byte[] result = null;

        try (FileInputStream fileInput = new FileInputStream(file);
                ByteArrayOutputStream byteArray = new ByteArrayOutputStream()) {

            byte[] buf = new byte[512];
            int readCount;
            while ((readCount = fileInput.read(buf)) != -1) { // read читает в массив, возвращает сколько байт прочитал или -1 если конец файла
                byteArray.write(buf, 0, readCount);
            }
            result = byteArray.toByteArray();

        } catch (FileNotFoundException e) {
            System.out.println("Файл не был найден");
        } catch (IOException e) {
            // Во время чтения из файла, что-то случилось с ресурсом, закрылось соединение в ресурсом
            System.out.println("Ошибка чтения из файла");
        }

        return result;
    }
}
