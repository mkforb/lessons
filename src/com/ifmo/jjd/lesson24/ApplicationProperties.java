package com.ifmo.jjd.lesson24;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by User on 14.05.2021.
 */
public class ApplicationProperties {
    // Реализация паттерна Одиночка для ОДНОПОТОЧНЫХ программ!
    private static ApplicationProperties instance; // Ссылка на экз. данного класса
    private Properties properties;
    private String fileName = "config.properties";

    private ApplicationProperties() {
        // Делаем конструктор приватным
        properties = new Properties();
        readProperties();
    }

    public static ApplicationProperties getInstance() {
        // Отложенная инициализация
        if (instance == null) {
            instance = new ApplicationProperties();
        }
        return instance;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void readProperties() {
        try (InputStream input = ApplicationProperties.class.getClassLoader().getResourceAsStream(fileName)) {
            properties.load(input);
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл");
        }
    }
}
