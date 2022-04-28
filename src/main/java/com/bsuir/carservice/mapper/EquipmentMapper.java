package com.bsuir.carservice.mapper;


import com.bsuir.carservice.dto.EquipmentDto;
import com.bsuir.carservice.model.Equipment;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR, uses = {CarMapper.class})
public interface EquipmentMapper {

    EquipmentDto equipmentToDto(Equipment equipment);
    Equipment dtoToEquipment(EquipmentDto equipmentDto);
}
