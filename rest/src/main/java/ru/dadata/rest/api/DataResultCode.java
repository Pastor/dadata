package ru.dadata.rest.api;

import java.io.Serializable;

public enum DataResultCode implements Serializable {
    SUCCESS("Запрос успешно обработан", 200),
    ILLEGAL_REQUEST("Некорректный запрос", 400),
    ILLEGAL_API_KEY("В запросе отсутствует идентификационный ключ (либо указан несуществующий ключ)", 403),
    ILLEGAL_METHOD("Запрос сделан с методом, отличным от POST", 405),
    ILLEGAL_DATA_COUNT("Запрос содержит более 50 записей в параметре data", 413),
    INTERNAL_SERVER_ERROR("Произошла внутренняя ошибка сервиса во время обработки", 500);

    public static DataResultCode valueOf(int value) {
        for (DataResultCode code : values()) {
            if (code.code == value) {
                return code;
            }
        }
        throw new IllegalArgumentException("Illegal result code " + value);
    }

    private DataResultCode(String desc, int code) {
        this.desc = desc;
        this.code = code;
    }

    private final String desc;
    private final int code;
}
