package com.bsuir.carservice.mapper;

import com.bsuir.carservice.dto.CarDto;
import com.bsuir.carservice.model.Car;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface CarMapper {

    CarDto carToDto(Car car);
    Car dtoToCar(CarDto carDto);
}
