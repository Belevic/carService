package com.bsuir.carservice.service;

import com.bsuir.carservice.dto.EquipmentDto;
import com.bsuir.carservice.mapper.EquipmentMapper;
import com.bsuir.carservice.repository.EquipmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EquipmentService {

    private final EquipmentRepository equipmentRepository;
    private final EquipmentMapper equipmentMapper;

    public EquipmentService(EquipmentRepository equipmentRepository, EquipmentMapper equipmentMapper) {
        this.equipmentRepository = equipmentRepository;
        this.equipmentMapper = equipmentMapper;
    }

    public List<EquipmentDto> getAll() {
        return equipmentRepository.findAll().stream().map(equipmentMapper::equipmentToDto).collect(Collectors.toList());
    }
}
