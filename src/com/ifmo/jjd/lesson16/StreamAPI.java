package com.ifmo.jjd.lesson16;

import com.ifmo.jjd.lesson15.education.Course;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAPI {
    public static void main(String[] args) {
        Stream<Integer> ints = Stream.of(2, 34, 596, -34, -459, 30);
        ints.filter(n -> n > 0)
                .map(n -> n * n)
                .limit(2) // Берет первые n элементов. Если n больше кол-ва эл-тов, то ошибки не будет
                .forEach(System.out::println);
        // filter, map, limit - промежуточные, forEach - конечная операция
        // Промежуточные операции не выполняются, если нет конечной.
        // После конечной операции стрим больше недоступен, он закрыт. Будет ошибка.

        System.out.println();

        ints = Stream.of(45, 956, -34, 58, -63, 58, -34);
        ints.distinct() // Оставит уникальные эл-ты
                .sorted() // Сортирует по возрастанию, исп-ет имплементированный ИФ Comparable
                .forEach(System.out::println);

        // anyMatch - хотя бы один, allMatch - все, noneMatch - ни один -- все конечные, возвр. boolean, принимиают предикат
        ints = Stream.of(45, 956, -34, 58, -63, 58, -34);
        System.out.println(ints.anyMatch(n -> n > 50)); // true, если хотя бы один элемент > 50

        ints = Stream.of(45, 956, -34, 58, -63, 58, -34);
        System.out.println(ints.allMatch(n -> n > 0));  // true, если все элементы > 0

        ints = Stream.of(45, 956, -34, 58, -63, 58, -34);
        System.out.println(ints.noneMatch(n -> n > 100));  // true, если ни один элемент > 100

        // findFirst, findAny - конечные (терминальные)
        // findFirst - возв. первый эл. потока
        // findAny - возв. произвольный эл. потока
        // Возв-ют эл-ты в Optional-контейнере
        // Optional-контейнер сущ-ет для избежания NullPointerException, исп-ся в стримах и при работе с БД
        String[] colors = {"red", "yellow", "blue", "black"};
        Optional<String> first = Arrays.stream(colors).findFirst();
        String elem = first.get(); // Если внутри будет null, то вызов get приведет к Exception
        elem = first.orElse("white"); // Вернет элем. из конт. или указанное значение, если в конт. null
        boolean isPresent = first.isPresent(); // true, если в конт. не null, иначе false
        System.out.println(elem);

        Arrays.stream(colors)
                .skip(2) // Пропускает заданное кол-во первых элементов
                .filter(s -> s.endsWith("k")) // Оставить эл-ты, которые заканчиваются на k
                .forEach(System.out::println);

        List<Course> courses = Course.getInstances(15);
        System.out.println();
        System.out.println(courses);

        // min, max - конечные, возв. мин. и макс. эл-т в Optional-контейнере, на вход принмим. Comparator
        Course minByPrice = courses.stream()
                .min(Comparator.comparing(Course::getPrice)) // Вернет Course с минимальной ценой в Optional-конт.
                .orElse(Course.getInstance());
        System.out.println(minByPrice);

        Course maxByDuration = courses.stream()
                .max(Comparator.comparing(Course::getDuration))
                .orElse(Course.getInstance());
        System.out.println(maxByDuration);

        // Массив курсов, стоимость которых больше 20000
        Course[] coursesArr = courses.stream()
                .filter(course -> course.getPrice() > 20000)
                .toArray(Course[]::new); // в toArray() надо передать ссылку на конструктор массива Course[]
        // toArray() возвр. массив типа Object[]
        System.out.println();
        System.out.println(Arrays.toString(coursesArr));

        List<Course> courseList = courses.stream()
                .filter(course -> course.getDuration() < 4)
                .peek(course -> course.setPrice(course.getPrice() + 10000))
                .collect(Collectors.toList());

        // map создает новые объекты и заменяет
        // peek меняет существующие объекты
        // Collectors создает List, Set

        Set<Course> courseSet = courses.stream()
                .filter(course -> course.getDuration() < 4)
                .collect(Collectors.toSet());

        ArrayList<Course> courseArrayList = courses.stream()
                .distinct() // Оставляет уникальные, исп-ет equals для сравнения
                .sorted(Comparator.comparing(Course::getDuration).thenComparing(Course::getPrice)) // Сорт. по продолжительности и стоимости
                .collect(Collectors.toCollection(ArrayList::new)); // В Collectors.toCollection передается ссылка на конструктор нужной коллекции (ArrayList)

        colors = new String[] {"blue", "yellow", "black", "white", "black"};
        Map<String, Integer> colorMap = Arrays.stream(colors).collect(Collectors.toMap(
                Function.identity(), // правило создания ключей // Function.identity() == color -> color // Function.identity() возвр. эл-т без преобразования
                String::length, // правило создания значений // String::length == color -> color.length()
                (item1, item2) -> item1 // что делать, если ключи одинаковые // оставляем первое добавленное
        ));

        String[][] strings = {
                {"67", "33", "0", "1"},
                {"554", "900", "33"},
                {"477", "477", "47111"}
        };

        String[][] strings1 = Arrays.stream(strings)
                .map(arr -> Arrays.stream(arr).distinct().sorted().toArray(String[]::new))
                .toArray(String[][]::new);

        System.out.println();
        System.out.println(Arrays.deepToString(strings1));

        String[] strings2 = Arrays.stream(strings)
                .flatMap(arr -> Arrays.stream(arr).distinct()) // Как map, только сглаживает, создет один поток
                .sorted()
                .toArray(String[]::new);

        System.out.println(Arrays.deepToString(strings2));
    }
}
