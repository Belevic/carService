package com.bsuir.carservice.mapper;

import com.bsuir.carservice.dto.SparePartDto;
import com.bsuir.carservice.model.SparePart;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface SparePartMapper {

    SparePartDto sparePartToDto(SparePart sparePart);
    SparePart dtoToSparePart(SparePartDto sparePartDto);
}
