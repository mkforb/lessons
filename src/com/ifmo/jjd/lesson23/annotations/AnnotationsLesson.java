package com.ifmo.jjd.lesson23.annotations;

import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Properties;

/**
 * Created by User on 12.05.2021.
 */
public class AnnotationsLesson {
    public static void main(String[] args) {
        // Информацию об аннотациях времени выполнения получаем с помощью рефлексии
        Class<Point> pointClass = Point.class;
        Annotation[] annotations = pointClass.getAnnotations(); // Аннотации класса
        System.out.println(Arrays.toString(annotations));
        // Чтобы получить аннотации методов или параметров, надо вызвать getAnnotations у метода или параметра

        if (pointClass.isAnnotationPresent(Component.class)) { // Проверка есть ли аннотация
            // В зависимости от наличия аннотации выполнить какие то действия
            Component component = pointClass.getDeclaredAnnotation(Component.class); // Получаем ссылку на аннотацию, чтобы получить ее параметры
            System.out.println(component.fileName());
            System.out.println(component.version());
        }

        Field[] fields = pointClass.getFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Required.class)) {
                System.out.println(field.getType());
                System.out.println(field.getName());
            }
        }

        // Д/з:
        // Если класс аннотирован Component
        // Создать объект данного класса рефлексивно (получить конструктор без параметров, создать объект)
        // Взять поля, проверить если поле аннотировано Required,
        // установтиь значение (из properties файла) данного поля, используя сеттер!!!
        // Обращаемся к рефлексивно созлданному оъекту
        // Если поле int x, то метод setX(int x), если String name - setName(String name)
        // Тип данных взять из поля

        // java.util.Properties
        // Изначально он с файлом properties никак не связан. Хранит данные похожим образов: ключ-значение
        // Данные хранятся как хэш-таблица. Ключи и значения - строки
        Properties properties = new Properties();
        properties.setProperty("ip", "127.0.0.1");
        properties.setProperty("port", "8999");

        // Получение
        System.out.println(properties.getProperty("ip"));
        System.out.println(properties.getProperty("port"));

        // В объект Properties можно выгрузить данные из properties-файла
        try (InputStream input = Annotation.class.getClassLoader().getResourceAsStream("point.properties")) {
            properties.load(input);
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл");
        }

    }
}
