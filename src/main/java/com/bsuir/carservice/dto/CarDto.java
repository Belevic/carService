package com.bsuir.carservice.dto;

import com.bsuir.carservice.model.BodyType;
import com.bsuir.carservice.model.DriveType;

import java.io.Serializable;

public class CarDto implements Serializable {
    private Long id;
    private String mark;
    private int year;
    private double weight;
    private double engineCapacity;
    private int sitAmount;
    private DriveType driveType;
    private BodyType bodyType;

    public CarDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(double engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public int getSitAmount() {
        return sitAmount;
    }

    public void setSitAmount(int sitAmount) {
        this.sitAmount = sitAmount;
    }

    public DriveType getDriveType() {
        return driveType;
    }

    public void setDriveType(DriveType driveType) {
        this.driveType = driveType;
    }

    public BodyType getBodyType() {
        return bodyType;
    }

    public void setBodyType(BodyType bodyType) {
        this.bodyType = bodyType;
    }
}
