package com.bsuir.carservice.dto;

import com.bsuir.carservice.model.CloseReason;
import com.bsuir.carservice.model.Status;

import java.io.Serializable;
import java.util.Date;

public class SparePartOrderDto implements Serializable {
    private Long id;
    private Date date;
    private int amount;
    private CloseReason closeReason;
    private Status status;
    private PersonDto person;
    private PersonDto manager;
    private SparePartDto sparePart;

    public SparePartOrderDto() {
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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public CloseReason getCloseReason() {
        return closeReason;
    }

    public void setCloseReason(CloseReason closeReason) {
        this.closeReason = closeReason;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
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

    public SparePartDto getSparePart() {
        return sparePart;
    }

    public void setSparePart(SparePartDto sparePart) {
        this.sparePart = sparePart;
    }
}
