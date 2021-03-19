package lesson1;
// ctrl + alt + l
// однострочный комментарий ctrl + /
/* ctrl + shift + /
* многострочный комментарий
* */

public class FirstLesson {
    // точка входа psvm + Enter
    public static void main(String[] args) {
        // консольный вывод
        // sout + Enter
        System.out.println("консольный вывод");
        // git --version - версия git

        // объявление переменных типДанных типПеременной;
        int count = 98234;
        int length = 122, width = 301, height = 501; // объявление нескольких перем.
        int size, page; // без присвоения нач. знач.
        size = 20;
        page = 6;
        // обращение к переменной происходит по ее имени
        System.out.println(size);

        // byte date = 500;
        int bill = 1_000_000; // для удобства чтения можно ставить подчеркивания

        float pi = 3.14F; // 3.14 считается как double. чтобы указать, что это float, нужно поставить в конце f или F

        long veryBig = 67_000_000_000L; // 67_000_000_000 считается как int и превышает допустимый диапазон. поэтому надо поставить l или L

        // деление на 0
        // целых чисел приводит к ошибке выполнения
        // System.out.println(bill / 0);

        // чисел с плавающей точкой Infinity
        System.out.println(pi / 0);

        // Преобразование типов
        double price = bill; // автоматическое приведение
        System.out.println(price);

        byte miniPrice = (byte) bill; // явное приведение
        System.out.println(miniPrice);

        byte a = 12, b = 90;
        byte ab = (byte) (a + b); // арифм. опер. над byte и short дают тип int

        // boolean имеет значение true или false
        boolean isActive = true;

        // Операторы
        height = 9;
        width = 2;

        // взятие остатка %
        System.out.println(height % width); // 1

        height = 8;
        width = 2;
        System.out.println(height % width); // 0

        // Присваивание
        height = height * 2; // height *= 2; // две записи идентичны
        System.out.println(height);

        width -= height; // width = width - height;
        System.out.println(width);

        // Операторы сравнения
        height = 8;
        width = 2;
        System.out.println(height != width); // true
        System.out.println(height > width); // true
        System.out.println(height <= width); // false

        // Тернарный оператор ?
        // переменная = логическое выражение/условие ? выражение1 : выражение2;

        double sum = bill > 1000 ? bill - bill * 0.1 : bill;
        System.out.println(sum);

        // Логические операторы

        // || ИЛИ
        boolean cancelled = false;
        System.out.println(bill > 0 || cancelled); // sout

        // && И
        int start = 3, end = 10;
        System.out.println(start < end && end < 100_000);

        // ! НЕ
        System.out.println(!cancelled);
        System.out.println(!(bill > 0 || cancelled)); // сначала выполняется значение в скобках, потом выполняется отрицание НЕ

        // ^ Исключающее ИЛИ (xor)
        System.out.println(bill > 0 ^ !cancelled);

        // Инкремент ++ - увеличивает значение переменной на 1
        // Декремент -- - уменьшает значение переменной на 1
        // Используется только с переменными
        height = 2;
        int result = height++ - ++height + height-- - ++height * ++height + --height;
        // 2 - 4 + 4 - 4 * 5 + 4 = -16
        System.out.println(result);
    }
}
