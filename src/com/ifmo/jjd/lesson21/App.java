package com.ifmo.jjd.lesson21;

/**
 * Created by User on 05.05.2021.
 */
public class App {
    public static void main(String[] args) {
        Student.Exam exam1 = new Student.Exam(5, "Биология");
        Student.Exam exam2 = new Student.Exam(3, "Физика");

        Student student = new Student("Вася");
        student.addExam(exam1);
        student.addExam(exam2);

        User user = new User(User.Level.HIGH, "q");
        // Объект внутреннего класса
        User.Account account1 = user.new Account(300);
        User.Account account2 = new User(User.Level.LOW, "asdf").new Account(100);
    }
}
