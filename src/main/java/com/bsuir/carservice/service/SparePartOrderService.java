package com.bsuir.carservice.service;


import com.bsuir.carservice.dto.CarOrderDto;
import com.bsuir.carservice.dto.OrderDto;
import com.bsuir.carservice.dto.ServiceOrderDto;
import com.bsuir.carservice.dto.SparePartOrderDto;
import com.bsuir.carservice.mapper.ServiceOrderMapper;
import com.bsuir.carservice.mapper.SparePartOrderMapper;
import com.bsuir.carservice.model.CarOrder;
import com.bsuir.carservice.model.ServiceOrder;
import com.bsuir.carservice.model.SparePartOrder;
import com.bsuir.carservice.repository.*;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SparePartOrderService {

    private final SparePartOrderRepository sparePartOrderRepository;
    private final PersonRepository personRepository;
    private final SparePartRepository sparePartRepository;
    private final SparePartOrderMapper sparePartOrderMapper;

    public SparePartOrderService(SparePartOrderRepository sparePartOrderRepository, SparePartOrderMapper sparePartOrderMapper,
                               PersonRepository personRepository, SparePartRepository sparePartRepository) {
        this.sparePartOrderMapper = sparePartOrderMapper;
        this.personRepository = personRepository;
        this.sparePartOrderRepository = sparePartOrderRepository;
        this.sparePartRepository = sparePartRepository;
    }

    public SparePartOrderDto save(OrderDto orderDto) {
        SparePartOrder sparePartOrder = new SparePartOrder();
        sparePartOrder.setDate(new Date());
        sparePartOrder.setStatus(orderDto.getStatus());
        sparePartOrder.setAmount(orderDto.getAmount());
        sparePartOrder.setPerson(personRepository.getById(orderDto.getPersonId()));
        sparePartOrder.setSparePart(sparePartRepository.getById(orderDto.getSparePartId()));

        return sparePartOrderMapper.sparePartOrderToDto(sparePartOrderRepository.save(sparePartOrder));
    }

    public SparePartOrderDto update(OrderDto orderDto) {
        SparePartOrder sparePartOrder = sparePartOrderRepository.getById(orderDto.getId());
        sparePartOrder.setStatus(orderDto.getStatus());

        if (orderDto.getManagerId() != null) {
            sparePartOrder.setManager(personRepository.getById(orderDto.getManagerId()));
        }

        if (orderDto.getCloseReason() != null) {
            sparePartOrder.setCloseReason(orderDto.getCloseReason());
        }

        return sparePartOrderMapper.sparePartOrderToDto(sparePartOrderRepository.save(sparePartOrder));
    }

    public List<SparePartOrderDto> getAll() {
        return sparePartOrderRepository.findAll().stream().map(sparePartOrderMapper::sparePartOrderToDto).collect(Collectors.toList());
    }
}

