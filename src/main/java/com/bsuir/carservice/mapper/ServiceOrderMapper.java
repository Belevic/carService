package com.bsuir.carservice.mapper;

import com.bsuir.carservice.dto.ServiceOrderDto;
import com.bsuir.carservice.model.ServiceOrder;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR, uses = {PersonMapper.class, ServiceMapper.class})
public interface ServiceOrderMapper {

    ServiceOrderDto serviceOrderToDto(ServiceOrder serviceOrder);
}
