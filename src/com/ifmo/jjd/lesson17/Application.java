package com.ifmo.jjd.lesson17;

import java.util.Arrays;

/**
 * Created by User on 23.04.2021.
 */
public class Application {
    public static void main(String[] args) {
        // Edit Configuration ->
        // Program Arguments
        // Параметры, с которыми запускается приложение перечисляются через пробел
        // При запуске собираются и передаются в массив args
        System.out.println(Arrays.toString(args));

        // Все классы кроме базовых загружаются по мере требования
        // Базовые загружаются сразу

        // Базовый bootstrap загрузчик - загружает баз. кл.
        // Загрузчик расширений Extension - загр. ArrayList, HashMap и т.д.
        // Системный загрузчик (system/application) - загр. наши классы и библиотеки

        // Кастомные загрузчики наследуются от java.lang.ClassLoader
        // Ко всем загрузчикам есть доступ из программы кроме базового
        System.out.println(Application.class.getClassLoader()); // Ссылка на загрузчик

        System.gc(); // Призывает GC начать сборку мусора. Но GC примет решение сам.

        // -XX:+PrintFlagsFinal
        long used = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println(used);
    }
}
