package com.ifmo.jjd.lesson20;

import java.io.IOException;
import java.nio.file.*;

public class WatchersExample {
    public static void main(String[] args) throws IOException, InterruptedException {
        // Пакет java.nio создан для работы с системой ввода/вывода
        // Есть классы и интерфейсы для работы с файлами (Path - хранит путь к файлу или директории)
        // Класс Paths - для создания объектов типа Path
        // Класс Files - в нем только стат. методы, которые позволяют записывать в файл, читать из файла, копировать, перемещать, проверки
        // Каналы, буферы, селекторы
        // Каналы - аналоги стримов, соединяет ресурс, один канал для записи и чтения, запись может происходить асинхронно,
        // каналы берут данные из буфера и пишут в буфер
        // Есть канал для работы с файлами, для создания клиентского сокета, для принятия входящих подключений
        // Напрямую данные из канала прочитать нельзя, только через буфер

        // создание объекта WatchService (будет следить за событиями по указанному в дальнейшем пути)
        WatchService watchService = FileSystems.getDefault().newWatchService();

        // создаем объект типа Path
        Path path = Paths.get(args[0]);

        // регистрируем path в WatchService на события: создание / удаление / изменение
        path.register(watchService,
                StandardWatchEventKinds.ENTRY_CREATE,
                StandardWatchEventKinds.ENTRY_DELETE,
                StandardWatchEventKinds.ENTRY_MODIFY);

        WatchKey key;
        // получаем ключ
        while ((key = watchService.take()) != null) {
            // получаем список произошедших событий
            for (WatchEvent<?> event : key.pollEvents()) {
                System.out.println(event.kind() + " : " + event.context());
            }
            key.reset();
        }

    }
}


