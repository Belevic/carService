package com.bsuir.carservice.service;

import com.bsuir.carservice.dto.OrdersDto;
import com.bsuir.carservice.mapper.CarOrderMapper;
import com.bsuir.carservice.mapper.ServiceOrderMapper;
import com.bsuir.carservice.mapper.SparePartOrderMapper;
import com.bsuir.carservice.model.Person;
import com.bsuir.carservice.repository.CarOrderRepository;
import com.bsuir.carservice.repository.PersonRepository;
import com.bsuir.carservice.repository.ServiceOrderRepository;
import com.bsuir.carservice.repository.SparePartOrderRepository;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class OrderService {

    private final CarOrderRepository carOrderRepository;
    private final ServiceOrderRepository serviceOrderRepository;
    private final SparePartOrderRepository sparePartOrderRepository;
    private final PersonRepository personRepository;
    private final CarOrderMapper carOrderMapper;
    private final ServiceOrderMapper serviceOrderMapper;
    private final SparePartOrderMapper sparePartOrderMapper;

    public OrderService(CarOrderRepository carOrderRepository, ServiceOrderRepository serviceOrderRepository,
                        SparePartOrderRepository sparePartOrderRepository, PersonRepository personRepository,
                        CarOrderMapper carOrderMapper, ServiceOrderMapper serviceOrderMapper,
                        SparePartOrderMapper sparePartOrderMapper) {
        this.carOrderRepository = carOrderRepository;
        this.serviceOrderRepository = serviceOrderRepository;
        this.sparePartOrderRepository = sparePartOrderRepository;
        this.personRepository = personRepository;
        this.carOrderMapper = carOrderMapper;
        this.serviceOrderMapper = serviceOrderMapper;
        this.sparePartOrderMapper = sparePartOrderMapper;
    }

    public OrdersDto getAllByPerson(Long personId) {
        Person person = personRepository.getById(personId);
        OrdersDto ordersDto = new OrdersDto();

        ordersDto.setCarOrders(carOrderRepository.getAllByPersonOrderByIdAsc(person).stream().map(carOrderMapper::carOrderToDto).collect(Collectors.toList()));
        ordersDto.setServiceOrders(serviceOrderRepository.getAllByPersonOrderByIdAsc(person).stream().map(serviceOrderMapper::serviceOrderToDto).collect(Collectors.toList()));
        ordersDto.setSparePartOrders(sparePartOrderRepository.getAllByPersonOrderByIdAsc(person).stream().map(sparePartOrderMapper::sparePartOrderToDto).collect(Collectors.toList()));
        return ordersDto;
    }
}
