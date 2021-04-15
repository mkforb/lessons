package com.ifmo.jjd.lesson13;

import java.util.*;

public class CollectionApp {
    public static void main(String[] args) {
        Student student1 = new Student("Петр", "Сбежинский", 18);
        Student student2 = new Student("Иван", "Петровский", 28);
        Student student3 = new Student("Томас", "Мюллер", 35);
        Student student4 = new Student("Киллиан", "Мбаппе", 22);

        // Lists

        ArrayList<Student> studentArrayList = new ArrayList<>(); // Создается массив на 10 элементов.
        // Когда емкости не хватает, емкость массива увеличивается, при этом
        // создается новый массив и в него перекладываются все элементы
        studentArrayList = new ArrayList<>(30); // Можно задать начальную длину при создании
        // Его также можно потом расширить
        System.out.println(studentArrayList.size()); // Возвращает кол-во элементов в коллекции, а не длину внутреннего массива
        studentArrayList.add(student1); // Добавляет элемент в коллекцию
        studentArrayList.add(student2);
        studentArrayList.add(1, student3); // Добавляет элемент в заданное место. Существующие элементы сдвинутся
        studentArrayList.addAll(Arrays.asList(student3, student4)); // Добавляет элементы другой коллекции
        // Arrays.asList -- создаст коллекцию из элементов
        studentArrayList.trimToSize(); // Сокращает внутренний массив до кол-ва элементов коллекции

        studentArrayList.remove(student3); // Удаление элемента
        studentArrayList.remove(0); // Удаление по индексу

        System.out.println(studentArrayList.get(2)); // Получить элемент по индексу
        // При обращении к несуществующему индексу получим exception

        // Перебор элементов коллекции
        for (Student student : studentArrayList) {
            // Здесь с элементом можно делать что угодно, но не удалять. Удалять нельзя!
            student.setAge(student.getAge() + 1);
            System.out.println(student.getName() + " " + student.getSurname());
        }

        LinkedList<Student> studentLinkedList = new LinkedList<>(); // Это внутри не массив, поэтому нельзя задать длину
        // LinkedList имеет методы List и Queue. От Queue есть методы addFirst, addLast
        studentLinkedList.add(student1);
        studentLinkedList.addFirst(student3); // Добавляет в начало
        studentLinkedList.addLast(student3); // Добавляет в конец
        studentLinkedList.add(2, student2);
        // Как таковых индексов нет, так как внутри не массиы, но есть внутренний счетчик, который отсчитывает

        // Перебрать linked list. Если возраст < 30, передать в array list
        for (Student student : studentLinkedList) {
            if (student.getAge() < 30) studentArrayList.add(student);
        }
        System.out.println(studentArrayList);
        System.out.println(studentLinkedList);

        List<Student> subList = studentLinkedList.subList(0, 2);

        studentLinkedList.remove(student3); // Для этого варианта должен быть переопределен метод equals
        studentLinkedList.remove(0);
        studentLinkedList.removeFirst();
        studentLinkedList.removeLast();

        // Sets
        // HashSet
        // LinkedSet
        // TreeSet

        Student[] students = {student1, student3, student4, student4};
        HashSet<Student> studentHashSet = new HashSet<>();
        studentHashSet = new HashSet<>(Arrays.asList(students)); // Создание на основе коллекции
        studentHashSet.add(student3);
        studentHashSet.add(student2);
        studentHashSet.remove(student2);
        // Нет операций по индексу и нет метода get(). Доступ к элементам -- перебором.

        System.out.println(studentHashSet);

        // TreeSet требует:
        // 1. Класс Student должен реализовывать Comparable интерфейс, чтобы хранить в TreeSet
        // 2. Создать объект Comparator и передать в конструктор
        // П. 2 гибче, больше возможностей
        // Строки, числа, даты уже имплементируют Comparable
        TreeSet<Student> studentTreeSet = new TreeSet<>();
        studentTreeSet.add(student1);
        studentTreeSet.add(student2);
        studentTreeSet.add(student3);

        Comparator<Student> comparator = new Student.AgeComparator().thenComparing(new Student.NameComparator());
        // Если несколько компараторов, то можно определить порядок сортировки.
        TreeSet<Student> studentTreeSet2 = new TreeSet<>(comparator);
    }
}
