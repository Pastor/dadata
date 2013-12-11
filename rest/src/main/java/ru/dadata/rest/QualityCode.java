package ru.dadata.rest;

import java.io.Serializable;

public enum QualityCode implements Serializable {
    UNDEFINED(-1, "Неопределен"),
    CORRECT(0, "Корректное исходное значение, не требует проверки"),
    HAS_ERROR(1, "Исходное значение может содержать ошибки или опечатки, требуется ручная проверка");

    QualityCode(int value, String desc) {
        this.value = value;
        this.desc = desc;

    }

    @Override
    public String toString() {
        return desc;
    }

    public static QualityCode valueOf(int value) {
        for (QualityCode code : values()) {
            if (code.value == value)
                return code;
        }
        throw new IllegalArgumentException("");
    }

    private final int value;
    private final String desc;
}
