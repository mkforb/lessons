package lesson4;

import java.util.Arrays;

public class ArraysLesson {
    public static void main(String[] args) {
        System.out.println("Массивы");
        // Объявление массива
        int len = 10;
        int[] ints = new int[len]; // переменная в качестве длины
        int[] ints1 = new int[10]; // длина задана конкретным значением
        int[] ints2 = new int[len + 2]; // длина задана через выражение

        int[] ints3 = {12, 45, 100, -5};
        // ints3 = {56, 87, -19}; // Перезаписать знач. массива таким способом нельзя
        // но можно так:
        ints3 = new int[]{56, 87, -19}; // это назыв-ся безымянный массив

        // Вывод массива в консоль
        System.out.println(ints3); // Так выводится хэш-код массива (это должен быть адрес в памяти, но это не так, потому что сборщик мусора перемещает объекты)
        System.out.println(Arrays.toString(ints3));

        // Доступ к элементам массива
        int elem = ints3[1]; // в квадр. скобках указ-ся индекс через значение, переменную или выражение
        System.out.println("ints3[1] = " + elem);
        ints3[0] = 73; // Изменение значения элемента массива
        System.out.println(Arrays.toString(ints3));

        // Обращение к несуществующему элементу массива
        // Приведет к ошибке времени выполнения, выполнение программы прерывается:
        // java.lang.ArrayIndexOutOfBoundsException
        // System.out.println(ints3[4]);

        // Многомерные массивы
        int[][] ints4 = new int[3][4]; // int - это тип конечных элементов
        // Создастся след. массив:
        // [[0, 0, 0, 0], [0, 0, 0, 0], [0, 0, 0, 0]]
        // Доступ к элементам многомерного массива
        ints4[1][2] = 90;
        ints4[2][3] = -45;
        // Вывод в консоль значений многомерного массива
        System.out.println(Arrays.deepToString(ints4));
        //
        int[][] ints5 = new int[4][];
        // Если указать длину только у основного массива, то получим:
        // [null, null, null, null]
        ints5[0] = new int[1]; // [[0], null, null, null]
        ints5[1] = new int[2]; // [[0], [0, 0], null, null]
        ints5[2] = new int[3]; // [[0], [0, 0], [0, 0, 0], null]
        ints5[3] = new int[4]; // [[0], [0, 0], [0, 0, 0], [0, 0, 0, 0]]
        System.out.println(Arrays.deepToString(ints5));

        // == для сравнения ссылочных типов не используется
        // == null -- но можно использовать для сравнения с null

        // Перебор элементов массива
        int[] ints6 = {2, 45, 983, -34, 635};

        // Цикл for позволяет изменять значения элементов массива
        // fori -- быстро сгенерировать цикл
        for (int i = 0; i < ints6.length; i++) {
            ints6[i] += 10;
        }
        System.out.println(Arrays.toString(ints6));

        // Цикл foreach не имеет доступа к индексам, не позволяет изменять значения элементов массива
        // iter -- быстро сгенерировать цикл
        for (int arrElem: ints6) {
            // Перебираем массив ints6, на каждой итерации значение элемента массива копируется в arrElem
            System.out.println(arrElem);
        }

        // Задание
        // Объявить массив типа double на 7 элементов
        // Заполнить его в цикле рандомными знач. (3, 100)
        // Найти минимальное значение в массиве
        double[] doubles = new double[7];
        double minValue = Double.MAX_VALUE;
        for (int i = 0; i < doubles.length; i++) {
            doubles[i] = 3 + Math.random() * 97;
            if (i == 0) minValue = doubles[i];
            else if (doubles[i] < minValue) minValue = doubles[i];
        }
        System.out.println(Arrays.toString(doubles));
        System.out.println(minValue);

        // Задание
        int[] ints7 = {90, 12, 67, -100, 56, 32};
        // Найти сумму значений элементов массива
        // Если значение элемента попадает в диапазон (12, 60), то
        // заменить его на значение по умолчанию
        int sum = 0;
        for (int i = 0; i < ints7.length; i++) {
            sum += ints7[i];
            if (ints7[i] > 12 && ints7[i] < 60) ints7[i] = 0;
        }
        System.out.println(Arrays.toString(ints7));
        System.out.println(sum);

        // Сравнение массивов
        int[] a = {34, 78, 10};
        int[] b = {34, 78, 10};
        System.out.println(a == b); // Будет false
        System.out.println(a.equals(b)); // equals то же, что и ==

        System.out.println(Arrays.equals(a, b));

        // Сортировка
        // Алгоритм быстрой сортировки -- Изучить как он работает!!!
        Arrays.sort(a);
        // Arrays.parallelSort(a); // параллельная сортировка
        System.out.println(Arrays.toString(a));

        // Копирование массивов
        a = new int[]{34, 90, -1};
        int[] newInt = a; // Создание дополнительной ссылки (а не копирование)

        int[] cloneArr = a.clone(); // Создание полной копии массива

        int[] copyArr = new int[10];
        System.arraycopy(a, 1, copyArr, 4, 2);
        System.out.println(Arrays.toString(copyArr));

        // Arrays.copyOf()

        a = new int[]{34, 90, -1, 200, -12};

        // Метод бинарного поиска в массиве
        // Если элемент найден, возвращает индекс найденного элемента
        // Если элемент не найден, возвращает отрицательное значение
        // Массив должен быть отсортирован
        Arrays.sort(a); // [-1, -12, 34, 90, 200]
        int res = Arrays.binarySearch(a, -1);
        System.out.println(res);
        res = Arrays.binarySearch(a, 35); // -4: 3+1
        System.out.println(res);
    }
}
