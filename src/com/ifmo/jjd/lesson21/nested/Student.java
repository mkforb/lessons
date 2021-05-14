package com.ifmo.jjd.lesson21.nested;

import java.util.ArrayList;

/**
 * Created by User on 05.05.2021.
 */
public class Student {
    private String name;
    private ArrayList<Exam> exams;

    public Student(String name) {
        this.name = name;
        exams = new ArrayList<>();
    }

    public void addExam(Exam exam) {
        exams.add(exam);
    }

    // Вложенный класс (nested static class)
    // Статическим может быть только вложенный класс
    // Класс верхнего уровня не может быть static
    // Из статического класса не можем обращаться к свойствам класса верхнего уровня
    // Область видимости вложенных классав - согласно модификатору доступа
    public static class Exam {
        private static final int MAX_MARK = 5;
        private int mark;
        private String examName;

        public Exam(int mark, String examName) {
            this.mark = mark;
            this.examName = examName;
        }
    }
}
