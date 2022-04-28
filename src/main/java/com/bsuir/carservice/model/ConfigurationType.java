package com.bsuir.carservice.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.stream.Stream;

public enum ConfigurationType {
    BASE("Базовая"), MIDDLE("Средняя"), MAX("Максимальная"), LIMITED("Лимитированная");

    private String value;

    ConfigurationType(String value) {
        this.value = value;
    }

    @JsonCreator
    public static ConfigurationType decode(final String code) {
        return Stream.of(ConfigurationType.values()).filter(type -> type.value.equals(code)).findFirst().orElse(null);
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
