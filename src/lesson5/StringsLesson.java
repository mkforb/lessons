package lesson5;

import java.util.Arrays;

public class StringsLesson {
    public static void main(String[] args) {
        // char 16 бит - символ Unicode
        // от 0 до 65535 от '\u0000' до '\uffff'

        char char1 = 'J'; // Символ в одинарных кавычках
        char char2 = 74; // Номер символа
        char char3 = '\u0044'; // Шестнадцатеричное представление в escape последовательности

        System.out.print(char1); // J
        System.out.print(char2); // J
        System.out.print(char3); // D
        System.out.println();

        // java.lang.String
        // Строки задаются либо в двойных кавычках: "строка",
        // либо с использованием одного из конструкторов и оператора new: new String()
        // Если возможно, использовать только создание через двойные кавычки

        // Создание строки из char
        char[] jjdChars = {'\u004a', '\u004a', '\u0044'};
        String jjdString = new String(jjdChars);
        System.out.println(jjdString); // JJD

        jjdString = "\u004a\u004a\u0044";
        jjdString = "JJD"; // то же самое что и в пред. строке
        System.out.println(jjdString); // JJD

        // Размер строки
        System.out.println(jjdString.length()); // JJD - 3
        System.out.println(jjdString.codePoints().count()); // 3

        char[] frogChars = {'\uD83D', '\uDC38'};
        String frogString = new String(frogChars);
        System.out.println(frogString);
        System.out.println(frogString.length()); // 🐸 - 2
        System.out.println(frogString.codePoints().count()); // 1 - кол-во символов Unicode
        // Суррогатная пара - когда один символ Unicode представлен двумя char

        // Пул строк
        String course1 = "Java"; // созд. объект в пуле строк
        String course2 = "Java"; // ищется в пуле, находит и созд. ссылку на уже созданный объект
        String course3 = new String("Java"); // созд. в хранилище объектов, не в пуле

        System.out.println(course1 == course2); // true
        System.out.println(course1 == course3); // false

        // Сравнение строк
        course1 = "Java Junior Developer";
        course2 = "Java Junior DEVELOPER";

        System.out.println(course1.equals(course2)); // false // чувствителен к регистру // сначала сравнивает размер, потом посимвольное сравнение
        System.out.println(course1.equalsIgnoreCase(course2)); // true // не чувствителен к регистру // сначала сравнивает размер // потом приводит к верхнему регистру и выполняет посимвольное сравнение
        System.out.println(course1.compareTo(course2)); // 32 = 101 (номер Unicode первого неравного символа) - 69 // возвращает int // 0 если строки равны // положительное значение, если строка, у которой вызывается метод, больше // отриц. - если наоборот
        System.out.println(course1.compareToIgnoreCase(course2)); // 0

        String userData = null;
        String exit = "exit";
        // System.out.println(userData.equals("exit")); // Здесь exception java.lang.NullPointerException // у null нельзя вызвать метод
        System.out.println(exit.equals(userData)); // Здесь OK

        // Строки вычисляются во время компиляции, обе строки попадут в пул и их ссылки будут равны
        String name1 = "Строки в Java";
        String name2 = "Строки" + " " + "в" + " " + "Java";
        System.out.println(name1 == name2); // true

        name1 = "Строки ";
        name2 = "в Java";
        System.out.println(name1 + name2 == name1 + name2); // false // вычисляются во время выполнения, создадутся разные объекты, ссылки будут не равны

        String start = "start";
        for (int i = 0; i < 4; i++) {
            start += " " + i; // На каждой итерации при конкатенации создается новый объект. Так делать не надо.
        }
        System.out.println(start);

        // Вместо этого исп-ся два класса, они идентичны, но
        // StringBuilder - работает быстрее, для однопоточных программ
        // StringBuffer - лучше работает в потоках, для многопоточных программ
        // Они не создают новые объекты при конкатенации

        StringBuilder sb = new StringBuilder();
        sb.append(name1).append(name2);
        String res = sb.toString(); // Объект java.lang.String создается только при вызове метода toString
        System.out.println(res);
        System.out.println(sb); // println вызывает у объекта метод toString

        // Перепишем цикл
        sb = new StringBuilder("start");
        for (int i = 0; i < 4; i++) {
            sb.append(" ").append(i); // в данном случае объект " " создается в пуле
            // Конкатенация без выражений (например, " " + "a") выполняется при компиляции, объекты создаются в пуле
            // " " + i -- создается объект во время выполнения, память потребляется
        }
        res = sb.toString();
        System.out.println(res);

        // Задание
        String[] animals = {"кот", "пес", "мышь"};
        // создать новый массив, который в два раза больше animals
        // в цикле заполнить новый массив рандомными значениями из массива animals
        String[] animals2 = new String[animals.length * 2];
        for (int i = 0; i < animals2.length; i++) {
            animals2[i] = animals[(int)(Math.random() * animals.length)];
        }
        System.out.println(Arrays.toString(animals2));

        // Убрать пробелы: начало, конец строки
        // trim() убирает пространство меньшее или равно u0020
        String someStr = " Строка ";
        someStr = someStr.trim();

        // Java 11: убирает любое пространство (например, u3000)
        // strip() - с двух сторон
        // stripLeading() - с начала строки
        // stripTrailing() - с конца строки

        // Получить массив символов из строки
        char[] formStr = someStr.toCharArray();
        System.out.println(Arrays.toString(formStr));

        String names = "Java, Kotlin, Python";
        String[] namesArr = names.split(", "); // Разбивает строку на массив по разделителю
        System.out.println(Arrays.toString(namesArr));

        names = String.join("! ", namesArr);
        // names = String.join("! ", "строка1", "строка 2");
        System.out.println(names);
    }
}
