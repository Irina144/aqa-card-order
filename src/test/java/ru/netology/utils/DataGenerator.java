package ru.netology.utils;

import com.github.javafaker.Faker;
import org.apache.commons.lang3.StringUtils;

public class DataGenerator {
    private static final Faker faker = new Faker(new java.util.Locale("ru"));

    public static String getValidName() {
        String name = faker.name().firstName() + " " + faker.name().lastName();
        // Дополнительная валидация: только буквы и пробелы
        if (StringUtils.isAlphaSpace(name)) {
            return name;
        } else {
            return getValidName(); // Рекурсивный вызов, если имя не соответствует требованиям
        }
    }

    public static String getValidPhone() {
        return "+7" + faker.number().digits(10);
    }
}
