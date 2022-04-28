package com.bsuir.carservice.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.stream.Stream;

public enum BodyType {
    CROSSOVER("Кроссовер"), SEDAN("Седан"), HATCHBACK("Хэтчбэк"), UNIVERSAL("Универсал");

    private String value;

    BodyType(String value) {
        this.value = value;
    }

    @JsonCreator
    public static BodyType decode(final String code) {
        return Stream.of(BodyType.values()).filter(bodyType -> bodyType.value.equals(code)).findFirst().orElse(null);
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
