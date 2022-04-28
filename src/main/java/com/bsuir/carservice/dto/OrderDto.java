package com.bsuir.carservice.dto;

import com.bsuir.carservice.model.CloseReason;
import com.bsuir.carservice.model.Status;

import java.util.Date;

public class OrderDto {
    private Long id;
    private CloseReason closeReason;
    private Status status;
    private Long personId;
    private Long managerId;
    private Long equipmentId;
    private Long serviceId;
    private Long sparePartId;
    private String serviceDate;
    private int amount;

    public OrderDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public Long getManagerId() {
        return managerId;
    }

    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }

    public Long getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(Long equipmentId) {
        this.equipmentId = equipmentId;
    }

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public Long getSparePartId() {
        return sparePartId;
    }

    public void setSparePartId(Long sparePartId) {
        this.sparePartId = sparePartId;
    }

    public String getServiceDate() {
        return serviceDate;
    }

    public void setServiceDate(String serviceDate) {
        this.serviceDate = serviceDate;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
