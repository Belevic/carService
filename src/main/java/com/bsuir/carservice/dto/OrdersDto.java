package com.bsuir.carservice.dto;

import java.util.List;

public class OrdersDto {
    private List<CarOrderDto> carOrders;
    private List<ServiceOrderDto> serviceOrders;
    private List<SparePartOrderDto> sparePartOrders;

    public OrdersDto() {
    }

    public List<CarOrderDto> getCarOrders() {
        return carOrders;
    }

    public void setCarOrders(List<CarOrderDto> carOrders) {
        this.carOrders = carOrders;
    }

    public List<ServiceOrderDto> getServiceOrders() {
        return serviceOrders;
    }

    public void setServiceOrders(List<ServiceOrderDto> serviceOrders) {
        this.serviceOrders = serviceOrders;
    }

    public List<SparePartOrderDto> getSparePartOrders() {
        return sparePartOrders;
    }

    public void setSparePartOrders(List<SparePartOrderDto> sparePartOrders) {
        this.sparePartOrders = sparePartOrders;
    }
}
