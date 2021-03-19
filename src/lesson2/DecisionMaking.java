package lesson2;

import java.util.Scanner;

public class DecisionMaking {
    public static void main(String[] args) {
        // Консольный ввод
        Scanner in = new Scanner(System.in);
        //System.out.println("Введите номер");
        //int userNum = in.nextInt();
        //System.out.println(userNum);

        // if
        int state = 0;
        if (state == 0) {
            System.out.println("Закрытие приложения");
        } else if (state == 1) {
            System.out.println("Открытие приложения");
        } else {
            System.out.println("Ошибка статуса");
        }

        int age = 50;
        int exp = 3;
        if (age < 0 || exp < 0 || exp > age) {
            System.out.println("Введены некорректные данные");
        } else {
            if (age > 100) {
                System.out.println("Мы Вам перезвоним");
            } else {
                if (exp < 5) {
                    System.out.println("Вы подходите на должность стажера");
                } else {
                    System.out.println("Вы подходите на должность разработчика");
                }
            }
        }

        int sum = 1000, code = 5984;
        switch (code) {
            case 4692:
                System.out.println(sum - sum * 0.3);
                break;
            case 7024:
            case 5984:
                System.out.println(sum - sum * 0.2);
                break;
            case 1235:
            case 7351:
            case 9835:
                System.out.println(sum - sum * 0.1);
                break;
            default:
                System.out.println(sum);
        }

        byte monthNum = 1;
        switch (monthNum) {
            case 1:
            case 2:
            case 12:
                System.out.println("Зима");
                break;
            case 3:
            case 4:
            case 5:
                System.out.println("Весна");
                break;
            case 6:
            case 7:
            case 8:
                System.out.println("Лето");
                break;
            case 9:
            case 10:
            case 11:
                System.out.println("Осень");
                break;
            default:
                System.out.println("Введен некорректный номер месяца");
        }

        // Циклы

        /*while (true) {
            System.out.println("Введите число");
            int num = in.nextInt();
            System.out.println(num + 2);
            if (num == 0) break;
        }*/

        // вывести все четные от start до end
        int start = 1, end = 14;
        while (start <= end) {
            if (start % 2 == 0) System.out.println(start);
            start++;
        }
        System.out.println();

        // Вывести все положительные элементы последовательности
        // 95, 90, 85 и т.д.
        for (int num = 95; num > 0; num -= 5) {
            System.out.println(num);
        }
        System.out.println();

        // Вывести первые 20 элементы последовательности
        // 2 4 6 8 10
        for (int num = 2, i = 1; i <= 20; num += 2, i++) {
            System.out.println(num);
        }
        
    }
}
