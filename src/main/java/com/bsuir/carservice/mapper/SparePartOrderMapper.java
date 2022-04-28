package com.bsuir.carservice.mapper;

import com.bsuir.carservice.dto.SparePartOrderDto;
import com.bsuir.carservice.model.SparePartOrder;
import org.mapstruct.*;

import java.text.SimpleDateFormat;
import java.util.Objects;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR, uses = {PersonMapper.class, SparePartMapper.class})
public interface SparePartOrderMapper {

    static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");

    @BeanMapping(qualifiedByName = "map")
    SparePartOrderDto sparePartOrderToDto(SparePartOrder sparePartOrder);

    @Named("map")
    @AfterMapping
    default void updateDate(SparePartOrder sparePartOrder, @MappingTarget SparePartOrderDto sparePartOrderDto) {
        if (Objects.nonNull(sparePartOrder.getDate())) {
            sparePartOrderDto.setDate(simpleDateFormat.format(sparePartOrder.getDate()));
        }
    }
}
