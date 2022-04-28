package com.bsuir.carservice.mapper;

import com.bsuir.carservice.dto.ServiceOrderDto;
import com.bsuir.carservice.model.ServiceOrder;
import org.mapstruct.*;

import java.text.SimpleDateFormat;
import java.util.Objects;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR, uses = {PersonMapper.class, ServiceMapper.class})
public interface ServiceOrderMapper {

    static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");

    @BeanMapping(qualifiedByName = "map")
    ServiceOrderDto serviceOrderToDto(ServiceOrder serviceOrder);

    @Named("map")
    @AfterMapping
    default void updateDate(ServiceOrder serviceOrder, @MappingTarget ServiceOrderDto serviceOrderDto) {
        if (Objects.nonNull(serviceOrder.getServiceDate())) {
            serviceOrderDto.setServiceDate(simpleDateFormat.format(serviceOrder.getServiceDate()));
        }
        if (Objects.nonNull(serviceOrder.getDate())) {
            serviceOrderDto.setDate(simpleDateFormat.format(serviceOrder.getDate()));
        }
    }
}
