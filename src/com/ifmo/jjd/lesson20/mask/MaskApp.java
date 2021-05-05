package com.ifmo.jjd.lesson20.mask;

/**
 * Created by User on 30.04.2021.
 */
public class MaskApp {
    public static void main(String[] args) {
        User user = new User();
        // Установить разрешения на работу с файлами и фотографиями
        user.setPermissions(Permissions.FILE | Permissions.PHOTO);
        // | - побитовое ИЛИ
        // 1000
        // 0001
        // Побитовое ИЛИ будет возвращать 1, если хотя бы одна 1, получаем:
        // 1001

        // Проверить наличие разрешений (пересечение масок)
        if ((user.getPermissions() & Permissions.AUDIO) != Permissions.AUDIO) {
            System.out.println("У вас нет разрешений на работу с аудио");
        } else {
            System.out.println("Доступ открыт");
        }
        // & - побитовое И
        // 1001
        // 0100
        // Побитовое И озвращает 1, если оба 1. Получим
        // 0000

        if ((user.getPermissions() & Permissions.FILE) != Permissions.FILE) {
            System.out.println("У вас нет разрешений на работу с файлами");
        } else {
            System.out.println("Доступ открыт");
        }

        // Исключить разрешения на работу с файлами
        user.setPermissions(user.getPermissions() & ~Permissions.FILE);
        // ~ инверсия, меняют биты на противоположные: ~1000 = 0111
        //         1001
        // 1000 -> 0111
        //         0001

    }
}
