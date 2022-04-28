package com.bsuir.carservice.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.stream.Stream;

public enum Status {
    WAITING("Ожидание"), IN_WORK("В работе"), ENDED("Обработано");

    private String value;

    Status(String value) {
        this.value = value;
    }

    @JsonCreator
    public static Status decode(final String code) {
        return Stream.of(Status.values()).filter(status -> status.value.equals(code)).findFirst().orElse(null);
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
