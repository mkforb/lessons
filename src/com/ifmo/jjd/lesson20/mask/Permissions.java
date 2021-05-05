package com.ifmo.jjd.lesson20.mask;

/**
 * Created by User on 30.04.2021.
 */
public class Permissions {
    // << -- оператор сдвига битов, после него указание на сколько надо сдвинуть
    // Есть договоренность, что каждый бит это разрешение на что-то
    // 0011 - разрешение на фото и видео
    // 0000 - отсутствие разрешений
    // 1111 - наличие всех разрешений
    public static final int PHOTO = 1; //  0001
    public static final int VIDEO = 1 << 1; // 0010 = 1 * 2
    public static final int AUDIO = 1 << 2; // 0100 = 1 * 2 * 2
    public static final int FILE = 1 << 3; // 1000 = 1 * 2 * 2 * 2
}
