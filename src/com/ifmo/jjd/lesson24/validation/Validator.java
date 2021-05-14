package com.ifmo.jjd.lesson24.validation;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.util.HashSet;

/**
 * Created by User on 14.05.2021.
 */
public class Validator<T> {
    private final T forValidation;
    private final HashSet<ValidationError> errors;

    public Validator(T forValidation) {
        this.forValidation = forValidation;
        errors = new HashSet<>();
    }

    public HashSet<ValidationError> getErrors() {
        return errors;
    }

    public void validate() {
        // Написать
        // берет forValidation, проверяет аннотации. Если проверка не прошла, добавить ошибку в HashSet
        Class<?> cl = forValidation.getClass();
        Field[] fields = cl.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Min.class)) {
                Min min = field.getDeclaredAnnotation(Min.class);
                try {
                    if ((int) getFieldValue(cl, field) < min.value()) {
                        errors.add(new ValidationError(field.getName(), min.errorMessage()));
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
            if (field.isAnnotationPresent(Max.class)) {
                Max max = field.getDeclaredAnnotation(Max.class);
                try {
                    if ((int) getFieldValue(cl, field) > max.value()) {
                        errors.add(new ValidationError(field.getName(), max.errorMessage()));
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
            if (field.isAnnotationPresent(Future.class)) {
                Future future = field.getDeclaredAnnotation(Future.class);
                try {
                    if (!((LocalDateTime) getFieldValue(cl, field)).isAfter(LocalDateTime.now())) {
                        errors.add(new ValidationError(field.getName(), future.errorMessage()));
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private Object getFieldValue(Class<?> cl, Field field) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = cl.getMethod("get"+field.getName().substring(0, 1).toUpperCase()+field.getName().substring(1));
        return method.invoke(forValidation);
    }

    public static class ValidationError {
        private final String fieldName;
        private final String errorMessage;

        public ValidationError(String fieldName, String errorMessage) {
            this.fieldName = fieldName;
            this.errorMessage = errorMessage;
        }

        public String getFieldName() {
            return fieldName;
        }

        public String getErrorMessage() {
            return errorMessage;
        }

        @Override
        public String toString() {
            return fieldName + ": " + errorMessage;
        }
    }
}
