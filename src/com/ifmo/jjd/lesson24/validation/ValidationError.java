package com.ifmo.jjd.lesson24.validation;

/**
 * Created by User on 14.05.2021.
 */
public class ValidationError {
    private String fieldName;
    private String errorMessage;
}

// Объявить аннотации Min, Max (для чисел): value (мин. или макс. значение), errorMessage (сообщение об ошибке)
// Аннотация Future (для дат и времени, дата должна быть в будущем): errorMessage