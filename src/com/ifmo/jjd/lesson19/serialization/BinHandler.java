package com.ifmo.jjd.lesson19.serialization;

import java.io.*;

/**
 * Created by User on 28.04.2021.
 */
public class BinHandler {
    private File file;

    public BinHandler(File file) {
        this.file = file;
    }

    public <T> boolean writeToFile(T object) {
        boolean result = false;
        try (FileOutputStream fileOutput = new FileOutputStream(file);
             ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput)) {
            objectOutput.writeObject(object);
            result = true;
        } catch (IOException e) {
            System.out.println("Ошибка записи в файл");
        }
        return result;
    }

    public <T> T readFromFile() {
        Object o = null;
        try (FileInputStream fileInput = new FileInputStream(file);
        ObjectInputStream objectInput = new ObjectInputStream(fileInput)) {
            o = objectInput.readObject(); // readObject всегда возвращает тип Object
        } catch (IOException | ClassNotFoundException e) {
            // FileNotFoundException является потомком IOException. Поэтому отдельно для него catch не пишем
            System.out.println("IOException или ClassNotFoundException");
        }
        return (T) o;
    }
}
