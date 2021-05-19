package com.ifmo.jjd.multithreading.lesson26.waitnotify;

import java.util.ArrayList;

/**
 * Created by User on 19.05.2021.
 */
public class Library {
    private ArrayList<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public synchronized void putBook() throws InterruptedException {
        // Ждать если 5 книг или больше. Надо делать в цикле, так как поток может проснуться сам по себе
        // if (books.size() == 5) wait(); // Так делать нельзя
        while (books.size() > 5) {
            System.out.println(Thread.currentThread().getName() + " пока хранилище переполнено, поток находится в ожидании");
            wait();
        }
        books.add(new Book());
        System.out.println("Книга добавлена. Всего " + books.size());
        notify();
    }

    public synchronized Book getBook() throws InterruptedException {
        while (books.size() == 0) {
            System.out.println(Thread.currentThread().getName() + " пока в хранилище пусто, поток находится в ожидании");
            wait();
        }
        Book book = books.remove(0);
        System.out.println("Книга удалена. Всего " + books.size());
        notify();
        return book;
    }

    public static class Book {

    }
}
