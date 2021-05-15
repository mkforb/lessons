package com.ifmo.jjd.lesson23.reflection;

import com.ifmo.jjd.lesson23.Text;

import java.lang.reflect.*;
import java.util.Arrays;

public class ReflectionLesson {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        /* Рефлексия - механизм, с помощью которого можно получать
        * информацию о классах, интерфейсах, полях и методах
        * во время выполнения программы.
        * Reflection API дает возможность создавать новые экземпляры классов,
        * получать и устанавливать значения свойств, вызывать методы. */

        Class<String> stringClass = String.class; // Ссылка на класс String
        System.out.println(stringClass);

        Class<Integer> integerClass = int.class;
        System.out.println(integerClass);

        Class<Text> textClass = Text.class;
        System.out.println(textClass);

        Text text = new Text("refre");
        text.setText("hfjshdfj hsjdhf jsdhfj hds");

        // Ввиду полиморфизма объект text может быть экземпляром подкласса Text
        Class<? extends Text> textClass2 = text.getClass(); // Class<Text> не можем написать, так возможно там наследник от Text
        System.out.println(textClass2);

        System.out.println(textClass.getName());
        System.out.println(textClass.getSimpleName());
        System.out.println(textClass.getPackageName());

        // ИФы которые имплементирует класс. Можем получить только те которые имплементирует сам класс но не его родители
        Class<?>[] interfaces = textClass.getInterfaces(); // <?> потому что не знаем что за ИФы
        System.out.println(Arrays.toString(interfaces));

        // родительский класс
        System.out.println(textClass.getSuperclass()); // Message
        System.out.println(textClass.getSuperclass().getSuperclass()); // Object
        System.out.println(textClass.getSuperclass().getSuperclass().getSuperclass()); // null

        // Доступ к компонентам класса (свойства (поля), методы, конструкторы)
        // Поля
        // У всех полей тип Field
        Field[] fields = textClass.getFields(); // Метод возвращает массив с публичными полями
        System.out.println(Arrays.toString(fields));

        Field[] declaredFields = textClass.getDeclaredFields(); // Все поля класса с любым модификатором доступа без родительских
        System.out.println(Arrays.toString(declaredFields));

        // Методы
        Method[] methods = textClass.getMethods();
        System.out.println(Arrays.toString(methods));

        Method[] declaredMethods = textClass.getDeclaredMethods();
        System.out.println(Arrays.toString(declaredMethods));

        // Конструкторы
        Constructor<?>[] declaredConstructor = textClass.getDeclaredConstructors();
        System.out.println(Arrays.toString(declaredConstructor));

        // Создание объекта
        Constructor<Text> textConstructor = textClass.getDeclaredConstructor(String.class); // Конструктор который принимает String. Если не найден, то будет Exception
        Text reflectText = textConstructor.newInstance("");

        // private String text;
        Field field = textClass.getDeclaredField("text");
        System.out.println(field.getType());
        System.out.println(field.getName());

        field.setAccessible(true); // Позволяет получить доступ к полю с любым модификатором
        field.set(reflectText, "jdhfj hjsdfh jhdsfj hj");
        System.out.println(field.get(reflectText));

        Method method = textClass.getDeclaredMethod("setText", String.class); // Получить ссылку на метод с названием setText и параметром String
        method.setAccessible(true);
        // reflectText.setText("text");
        method.invoke(reflectText, "text text");

        System.out.println(method.getGenericReturnType()); // Тип возвращаемого значения
        System.out.println(Arrays.toString(method.getGenericParameterTypes())); // Тип принимаемых параметров
        System.out.println(Arrays.toString(method.getGenericExceptionTypes())); // Исключения

        Modifier.isPrivate(field.getModifiers());
    }

    // Д/з:
    // Написать рефлексивный статический метод toString(Object o)
    // toString(Object);
    // obj: int, boolean, String, User, String[]
    public static void toString(Object o) {

    }
}
