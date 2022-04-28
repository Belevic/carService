package com.bsuir.carservice.dto;

import com.bsuir.carservice.model.CloseReason;
import com.bsuir.carservice.model.Status;

import java.io.Serializable;
import java.util.Date;

public class CarOrderDto implements Serializable {
    private Long id;
    private Date date;
    private CloseReason closeReason;
    private Status status;
    private PersonDto person;
    private PersonDto manager;
    private EquipmentDto equipment;

    public CarOrderDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public CloseReason getCloseReason() {
        return closeReason;
    }

    public void setCloseReason(CloseReason closeReason) {
        this.closeReason = closeReason;
    }

    public PersonDto getPerson() {
        return person;
    }

    public void setPerson(PersonDto person) {
        this.person = person;
    }

    public PersonDto getManager() {
        return manager;
    }

    public void setManager(PersonDto manager) {
        this.manager = manager;
    }

    public EquipmentDto getEquipment() {
        return equipment;
    }

    public void setEquipment(EquipmentDto equipment) {
        this.equipment = equipment;
    }
}
