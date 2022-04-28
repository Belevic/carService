package com.bsuir.carservice.service;


import com.bsuir.carservice.dto.CarOrderDto;
import com.bsuir.carservice.dto.OrderDto;
import com.bsuir.carservice.dto.ServiceOrderDto;
import com.bsuir.carservice.mapper.CarOrderMapper;
import com.bsuir.carservice.mapper.ServiceOrderMapper;
import com.bsuir.carservice.model.CarOrder;
import com.bsuir.carservice.model.ServiceOrder;
import com.bsuir.carservice.repository.*;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceOrderService {

    private final ServiceOrderRepository serviceOrderRepository;
    private final PersonRepository personRepository;
    private final ServiceRepository serviceRepository;
    private final ServiceOrderMapper serviceOrderMapper;

    public ServiceOrderService(ServiceOrderRepository serviceOrderRepository, ServiceOrderMapper serviceOrderMapper,
                           PersonRepository personRepository, ServiceRepository serviceRepository) {
        this.serviceOrderRepository = serviceOrderRepository;
        this.personRepository = personRepository;
        this.serviceRepository = serviceRepository;
        this.serviceOrderMapper = serviceOrderMapper;
    }

    public ServiceOrderDto save(OrderDto orderDto) {
        ServiceOrder serviceOrder = new ServiceOrder();
        serviceOrder.setDate(new Date());
        serviceOrder.setServiceDate(orderDto.getServiceDate());
        serviceOrder.setStatus(orderDto.getStatus());
        serviceOrder.setPerson(personRepository.getById(orderDto.getPersonId()));
        serviceOrder.setService(serviceRepository.getById(orderDto.getServiceId()));

        return serviceOrderMapper.serviceOrderToDto(serviceOrderRepository.save(serviceOrder));
    }

    public ServiceOrderDto update(OrderDto orderDto) {
        ServiceOrder serviceOrder = serviceOrderRepository.getById(orderDto.getId());
        serviceOrder.setStatus(orderDto.getStatus());
        serviceOrder.setServiceDate(orderDto.getServiceDate());

        if (orderDto.getManagerId() != null) {
            serviceOrder.setManager(personRepository.getById(orderDto.getManagerId()));
        }

        if (orderDto.getCloseReason() != null) {
            serviceOrder.setCloseReason(orderDto.getCloseReason());
        }

        return serviceOrderMapper.serviceOrderToDto(serviceOrderRepository.save(serviceOrder));
    }

    public List<ServiceOrderDto> getAll() {
        return serviceOrderRepository.findAll().stream().map(serviceOrderMapper::serviceOrderToDto).collect(Collectors.toList());
    }
}
