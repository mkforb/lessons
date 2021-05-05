package com.ifmo.jjd.lesson19.serialization.socketstream;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by User on 28.04.2021.
 */
public class Server {
    private int port;
    private Connection connection;

    public Server(int port) {
        this.port = port;
    }

    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(port)) { // Запускается и ждет
            System.out.println("Сервер запущен");
            while (true) {
                // Ожидание
                Socket newClient = serverSocket.accept(); // Установка соединения с клиентом
                connection = new Connection(newClient);
                SimpleMessage message = (SimpleMessage) connection.readMessage();
                System.out.println(message);
                connection.sendMessage(SimpleMessage.getMessage("сервер", "сообщение принято"));
            }
        } catch (IOException e) {
            System.out.println("Ошибка сервера");
        } catch (ClassNotFoundException e) {
            System.out.println("Ошибка чтения сообщения");
        }
    }
}
