package com.ifmo.jjd.multithreading.lesson25;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Comparator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by User on 14.05.2021.
 */
public class Reader implements Runnable { // implements Runnable используется, чтобы можно было отнаследоваться от другого класса
    // На данный момент класс Reader потоком не является
    // Все что должно выполняться параллельно, находится в методе run()

    private CopyOnWriteArrayList<Course> courses;

    public Reader(CopyOnWriteArrayList<Course> courses) {
        this.courses = courses;
    }

    @Override
    public void run() {
        System.out.println("Reader");
        while (true) {
            Course course = courses.stream().min(Comparator.comparing(Course::getPrice)).orElse(Course.getInstance());
            String forFile = "READER " + Thread.currentThread().getName() + " выбрал курс " + course + "\n";
            try {
                Files.writeString(Path.of("resources/courses.txt"), forFile, StandardOpenOption.APPEND);
                courses.remove(course);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(10000);
                // Приостанавливает текущий поток на указ. кол-во милисек. Когда указ. кол-во милисек. пройдет, поток продолжит работу
                // После этого планировщик потоков примет решение, когда возобновить поток. В реальности время ожидания будет больше
                // Thread.sleep не надо использовать. Если приходится его использовать, значит, программа написана неправильно
                // Если поток находится в спящем состоянии (TIME WAITING) и у потока будет вызван метод interrupt, вызовется InterruptedException
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
