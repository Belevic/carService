package com.bsuir.carservice.mapper;

import com.bsuir.carservice.dto.SparePartOrderDto;
import com.bsuir.carservice.model.SparePartOrder;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR, uses = {PersonMapper.class, SparePartMapper.class})
public interface SparePartOrderMapper {

    SparePartOrderDto sparePartOrderToDto(SparePartOrder sparePartOrder);
}
