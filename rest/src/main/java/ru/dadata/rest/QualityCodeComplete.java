package ru.dadata.rest;

import java.io.Serializable;

public enum QualityCodeComplete implements Serializable {
    UNDEFINED(-1, "Неопределен"),
    CORRECT(0, "Пригоден для почтовой рассылки"),
    HAS_NO_REGION(1, "Нет региона"),
    HAS_NO_CITY(2, "Нет города"),
    HAS_NO_STREET(3, "Нет улицы"),
    HAS_NO_HOME(4, "Нет дома"),
    HAS_NO_APARTAMENT(5, "Нет квартиры"),
    NOT_FOR_MAILING(6, "Не пригоден для почтовой рассылки"),
    FOREIGN_ADDRESS(7, "Иностранный");

    QualityCodeComplete(int value, String desc) {
        this.value = value;
        this.desc = desc;

    }

    @Override
    public String toString() {
        return desc;
    }

    public static QualityCodeComplete valueOf(int value) {
        for (QualityCodeComplete cc : values()) {
            if (cc.value == value)
                return cc;
        }
        throw new IllegalArgumentException("");
    }

    private final int value;
    private final String desc;
}
