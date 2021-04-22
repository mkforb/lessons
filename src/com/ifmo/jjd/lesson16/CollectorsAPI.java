package com.ifmo.jjd.lesson16;

import com.ifmo.jjd.lesson15.education.Course;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectorsAPI {
    public static void main(String[] args) {
        // Группировки
        ArrayList<Course> courses = new ArrayList<>(Course.getInstances(20));

        // Создать мапу: ключ - название курса, значение - список курсов с таким названием
        Map<String, List<Course>> byName = courses.stream()
                .collect(Collectors.groupingBy(course -> course.getName()));

        System.out.println(byName);

        // Мапа - продолжительность, список курсов с такой продолжительностью
        Map<Integer, ArrayList<Course>> byDuration = courses.stream()
                .collect(Collectors.groupingBy(course -> course.getDuration(), Collectors.toCollection(ArrayList::new))); // с преобразованием к ArrayList

        System.out.println(byDuration);

        // Мапа - название, кол-во курсов с таким названием
        Map<String, Long> coursesCount = courses.stream()
                .collect(Collectors.groupingBy(course -> course.getName(), Collectors.counting()));

        System.out.println(coursesCount);

        // Мапа - название, средняя цена курсов с таким названием
        Map<String, Double> avgPrice = courses.stream()
                .collect(Collectors.groupingBy(course -> course.getName(), Collectors.averagingDouble(course -> course.getPrice())));

        System.out.println(avgPrice);

        // Мапа - название, мапа (продолжительность, список курсов)
        Map<String, Map<Integer, List<Course>>> byNameDuration = courses.stream()
                .collect(Collectors.groupingBy(
                        course -> course.getName(),
                        Collectors.groupingBy(course -> course.getDuration())
                ));

        System.out.println(byNameDuration);

        // Создать список List из строк - уникальные названия в отсортиров. порядке
        List<String> sortedNames = courses.stream()
                .map(course -> course.getName())
                .distinct()
                .sorted()
                .collect(Collectors.toList());

        System.out.println(sortedNames);
        
    }
}
