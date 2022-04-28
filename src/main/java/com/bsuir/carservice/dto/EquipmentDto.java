package com.bsuir.carservice.dto;

import com.bsuir.carservice.model.ConfigurationType;
import com.bsuir.carservice.model.Equipment;

public class EquipmentDto {
    private Long id;
    private double price;
    private ConfigurationType configurationType;
    private CarDto car;

    public EquipmentDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ConfigurationType getConfigurationType() {
        return configurationType;
    }

    public void setConfigurationType(ConfigurationType configurationType) {
        this.configurationType = configurationType;
    }

    public CarDto getCar() {
        return car;
    }

    public void setCar(CarDto car) {
        this.car = car;
    }
}
