package com.bsuir.carservice.service;


import com.bsuir.carservice.dto.OrderDto;
import com.bsuir.carservice.dto.ServiceOrderDto;
import com.bsuir.carservice.mapper.ServiceOrderMapper;
import com.bsuir.carservice.model.ServiceOrder;
import com.bsuir.carservice.model.Status;
import com.bsuir.carservice.repository.PersonRepository;
import com.bsuir.carservice.repository.ServiceOrderRepository;
import com.bsuir.carservice.repository.ServiceRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ServiceOrderService {

    private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");

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

    public ServiceOrderDto save(OrderDto orderDto) throws ParseException {
        ServiceOrder serviceOrder = new ServiceOrder();
        serviceOrder.setDate(new Date());
        serviceOrder.setServiceDate(simpleDateFormat.parse(orderDto.getServiceDate()));
        serviceOrder.setStatus(Status.WAITING);
        serviceOrder.setPerson(personRepository.getById(orderDto.getPersonId()));
        serviceOrder.setService(serviceRepository.getById(orderDto.getServiceId()));

        return serviceOrderMapper.serviceOrderToDto(serviceOrderRepository.save(serviceOrder));
    }

    public ServiceOrderDto update(OrderDto orderDto) throws ParseException {
        ServiceOrder serviceOrder = serviceOrderRepository.getById(orderDto.getId());
        serviceOrder.setStatus(orderDto.getStatus());

        if (Objects.nonNull(orderDto.getServiceDate())) {
            serviceOrder.setServiceDate(simpleDateFormat.parse(orderDto.getServiceDate()));
        }

        if (Objects.isNull(serviceOrder.getManager()) && Objects.nonNull(orderDto.getManagerId())) {
            serviceOrder.setManager(personRepository.getById(orderDto.getManagerId()));
        }

        if (Objects.nonNull(orderDto.getCloseReason())) {
            serviceOrder.setCloseReason(orderDto.getCloseReason());
        }

        return serviceOrderMapper.serviceOrderToDto(serviceOrderRepository.save(serviceOrder));
    }

    public List<ServiceOrderDto> getAllByPerson(Long personId) {
        return serviceOrderRepository.getAllByPersonOrderByIdAsc(personRepository.getById(personId))
                .stream().map(serviceOrderMapper::serviceOrderToDto).collect(Collectors.toList());
    }

    public List<ServiceOrderDto> getAll() {
        return serviceOrderRepository.findAll(Sort.by("id").ascending()).stream().map(serviceOrderMapper::serviceOrderToDto).collect(Collectors.toList());
    }
}
