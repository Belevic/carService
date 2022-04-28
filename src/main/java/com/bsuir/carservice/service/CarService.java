package com.bsuir.carservice.service;

import com.bsuir.carservice.dto.ServiceDto;
import com.bsuir.carservice.mapper.ServiceMapper;
import com.bsuir.carservice.repository.ServiceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarService {

    private final ServiceRepository serviceRepository;
    private final ServiceMapper serviceMapper;

    public CarService(ServiceRepository serviceRepository, ServiceMapper serviceMapper) {
        this.serviceRepository = serviceRepository;
        this.serviceMapper = serviceMapper;
    }

    public List<ServiceDto> getAll() {
        return serviceRepository.findAll().stream().map(serviceMapper::serviceToDto).collect(Collectors.toList());
    }
}
