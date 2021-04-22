package com.ifmo.jjd.lesson15;

import com.ifmo.jjd.lesson15.education.Course;
import com.ifmo.jjd.lesson15.education.University;

import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class LambdaWithCollections {
    public static void main(String[] args) {
        University university = new University();
        university.addCourses(Course.getInstances(15));

        // Перебор коллекции - метод forEach(Consumer c)
        // Принимает на вход Consumer - void accept(T t);
        Consumer<Course> courseConsumer = course -> System.out.println(course);
        // Можно заменить на:
        courseConsumer = System.out::println; // ::имяМетода -- ссылка на метод

        university.getCourses().forEach(courseConsumer); // forEach перебирает элементы коллекции
        // Увеличить стоимость курса на 10%
        university.getCourses().forEach(course -> course.setPrice(course.getPrice() * 1.1));
        System.out.println();
        university.getCourses().forEach(courseConsumer);
        System.out.println();
        university.getCourses().forEach(course -> System.out.println(course.getName()));

        // Удаление из коллекции - метод removeIf()
        // Принимает на вход Predicate - boolean test(T t);
        // Удалить курсы, стоимость которых меньше 15000
        university.getCourses().removeIf(course -> course.getPrice() < 15000);
        System.out.println();
        university.getCourses().forEach(courseConsumer);

        // В классе University написать реализацию метода getFilteredCourses(Predicate<Course> condition),
        // который принимает на вход Predicate и возвращает новый список,
        // в который войдут курсы, удовлетворяющие условию condition
        // Курсы дешевле 20000
        // Курсы продолжительностью 3 и менее месяца
        // Курсы с названием JJD
        Predicate<Course> less20000 = course -> course.getPrice() < 20000;
        Predicate<Course> less3Mon = course -> course.getDuration() <= 3;
        Predicate<Course> nameJJD = course -> course.getName().equals("JJD");

        // Получить список курсов продолжительностью 3 и менее месяцев и стоимостью менее 20000
        System.out.println();
        university.getFilteredCourses(less20000.and(less3Mon)).forEach(courseConsumer);

        // Получить список курсов продолжительностью 3 и менее месяцев или с названием JJD
        System.out.println();
        university.getFilteredCourses(less3Mon.or(nameJJD)).forEach(courseConsumer);

        // Компараторы
        // int compare(T o1, T o2);
        Comparator<Course> byName = (course1, course2) -> course1.getName().compareToIgnoreCase(course2.getName());
        Comparator<Course> byPrice = (course1, course2) -> Double.compare(course1.getPrice(), course2.getPrice());

        university.getCourses().sort(byName.thenComparing(byPrice));

        // Метод Comparator.comparing
        // Принимает на вход Function - R apply(T t)
        byName = Comparator.comparing(course -> course.getName()); // Не описываем как сравнивать, описываем по какому свойству сравниваем. Он использует для сравнения compareTo
        byPrice = Comparator.comparing(course -> course.getPrice());
        // Можно заменить на:
        // Function<Course, String>
        byName = Comparator.comparing(Course::getName);
        // Function<Course, Double>
        byPrice = Comparator.comparing(Course::getPrice);

        Comparator<Course> courseComparator = Comparator.comparing(Course::getName)
                .thenComparing(Course::getPrice)
                .thenComparing(Course::getDuration);

        university.getCourses().sort(courseComparator);
    }
}
