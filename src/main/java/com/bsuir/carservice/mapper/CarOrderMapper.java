package com.bsuir.carservice.mapper;

import com.bsuir.carservice.dto.CarOrderDto;
import com.bsuir.carservice.model.CarOrder;
import org.mapstruct.*;

import java.text.SimpleDateFormat;
import java.util.Objects;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR, uses = {PersonMapper.class, EquipmentMapper.class})
public interface CarOrderMapper {

    static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");

    @BeanMapping(qualifiedByName = "map")
    CarOrderDto carOrderToDto(CarOrder carOrder);

    @Named("map")
    @AfterMapping
    default void updateDate(CarOrder carOrder, @MappingTarget CarOrderDto carOrderDto) {
        if (Objects.nonNull(carOrder.getDate())) {
            carOrderDto.setDate(simpleDateFormat.format(carOrder.getDate()));
        }
    }
}
