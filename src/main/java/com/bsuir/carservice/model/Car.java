package com.bsuir.carservice.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "car")
public class Car implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false, updatable = false)
    protected Long id;

    @Version
    @Column(nullable = false)
    private Integer version;

    @Column(nullable = false)
    private String mark;

    @Column(nullable = false)
    private int year;

    @Column(nullable = false)
    private double weight;

    @Column(name = "engine_capacity", nullable = false)
    private double engineCapacity;

    @Column(name = "sit_amount", nullable = false)
    private int sitAmount;

    @Column(name = "drive_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private DriveType driveType;

    @Column(name = "body_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private BodyType bodyType;

    public Car() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
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
