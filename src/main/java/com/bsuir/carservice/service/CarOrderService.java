package com.bsuir.carservice.service;

import com.bsuir.carservice.dto.CarOrderDto;
import com.bsuir.carservice.dto.OrderDto;
import com.bsuir.carservice.mapper.CarOrderMapper;
import com.bsuir.carservice.model.CarOrder;
import com.bsuir.carservice.repository.CarOrderRepository;
import com.bsuir.carservice.repository.EquipmentRepository;
import com.bsuir.carservice.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarOrderService {

    private final CarOrderRepository carOrderRepository;
    private final PersonRepository personRepository;
    private final EquipmentRepository equipmentRepository;
    private final CarOrderMapper carOrderMapper;

    public CarOrderService(CarOrderRepository carOrderRepository, CarOrderMapper carOrderMapper,
                           PersonRepository personRepository, EquipmentRepository equipmentRepository) {
        this.carOrderRepository = carOrderRepository;
        this.personRepository = personRepository;
        this.equipmentRepository = equipmentRepository;
        this.carOrderMapper = carOrderMapper;
    }

    public CarOrderDto save(OrderDto orderDto) {
        CarOrder carOrder = new CarOrder();
        carOrder.setDate(new Date());
        carOrder.setStatus(orderDto.getStatus());
        carOrder.setPerson(personRepository.getById(orderDto.getPersonId()));
        carOrder.setEquipment(equipmentRepository.getById(orderDto.getEquipmentId()));

        return carOrderMapper.carOrderToDto(carOrderRepository.save(carOrder));
    }

    public CarOrderDto update(OrderDto orderDto) {
        CarOrder carOrder = carOrderRepository.getById(orderDto.getId());
        carOrder.setStatus(orderDto.getStatus());

        if (orderDto.getManagerId() != null) {
            carOrder.setManager(personRepository.getById(orderDto.getManagerId()));
        }

        if (orderDto.getCloseReason() != null) {
            carOrder.setCloseReason(orderDto.getCloseReason());
        }

        return carOrderMapper.carOrderToDto(carOrderRepository.save(carOrder));
    }

    public List<CarOrderDto> getAll() {
        return carOrderRepository.findAll().stream().map(carOrderMapper::carOrderToDto).collect(Collectors.toList());
    }
}
