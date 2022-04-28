package com.bsuir.carservice.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.stream.Stream;

public enum CloseReason {
    SUCCESS("Заказ обработан"), CANCELED("Заказ отменен");

    private String value;

    CloseReason(String value) {
        this.value = value;
    }

    @JsonCreator
    public static CloseReason decode(final String code) {
        return Stream.of(CloseReason.values()).filter(reason -> reason.value.equals(code)).findFirst().orElse(null);
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
