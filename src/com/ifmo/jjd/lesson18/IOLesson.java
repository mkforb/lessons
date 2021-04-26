package com.ifmo.jjd.lesson18;

import com.ifmo.jjd.lesson18.handlers.ImgHandler;
import com.ifmo.jjd.lesson18.handlers.TxtHandler;

import java.io.File;
import java.io.IOException;

/**
 * Created by User on 26.04.2021.
 */
public class IOLesson {
    public static void main(String[] args) {
        String text = "ldfdkf llfksldkf lkdflk sdlfkdslfkldskfl kdsfl kdlfk ldskf lkdsfl";

        TxtHandler txtHandler = new TxtHandler(new File("file.txt")); // Если не указываем полный путь, то от корня проекта
        System.out.println(txtHandler.writeToFile(text.getBytes()));
        // getBytes у строки возвращает массив с байтами
        // в getBytes можно передать кодировку (StandardCharset.UTF_8)
        System.out.println(txtHandler.writeFromConsole());
        String fromFile = new String(txtHandler.readFromFile());
        System.out.println(fromFile);

        ImgHandler handler = new ImgHandler(new File("img.jpg"));
        byte[] bytes = new byte[0];
        try {
            bytes = handler.readFromFile();
            handler.setFile(new File("newImg.jpg"));
            handler.writeToFile(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
