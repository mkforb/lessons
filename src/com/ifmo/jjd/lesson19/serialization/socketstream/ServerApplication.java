package com.ifmo.jjd.lesson19.serialization.socketstream;

/**
 * Created by User on 28.04.2021.
 */
public class ServerApplication {
    public static void main(String[] args) {
        new Server(8999).start();
    }
}
