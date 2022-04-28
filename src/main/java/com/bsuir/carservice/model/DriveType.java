package com.bsuir.carservice.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.stream.Stream;

public enum DriveType {
    FULL("Полный"), FRONT("Передний"), REAR("Задний");

    private String value;

    DriveType(String value) {
        this.value = value;
    }

    @JsonCreator
    public static DriveType decode(final String code) {
        return Stream.of(DriveType.values()).filter(type -> type.value.equals(code)).findFirst().orElse(null);
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
