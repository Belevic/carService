package com.bsuir.carservice.mapper;

import com.bsuir.carservice.dto.CarOrderDto;
import com.bsuir.carservice.model.CarOrder;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR, uses = {PersonMapper.class, EquipmentMapper.class})
public interface CarOrderMapper {

    CarOrderDto carOrderToDto(CarOrder carOrder);
}
