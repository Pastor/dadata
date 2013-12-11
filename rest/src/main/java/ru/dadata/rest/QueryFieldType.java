package ru.dadata.rest;

import java.io.Serializable;

public enum QueryFieldType implements Serializable {
    IGNORE("Игнорировать поле (будет остутствовать в ответе)"),
    AS_IS("Скопировать поле в ответ \"как есть\""),
    NAME("ФИО"),
    BIRTHDATE("Дата рождения"),
    PHONE("Телефон"),
    ADDRESS("Адрес"),
    EMAIL("Адрес электронной почты");

    QueryFieldType(String desc) {
        this.desc = desc;
    }

    private final String desc;
}
