package com.bsuir.carservice.mapper;

import com.bsuir.carservice.dto.ServiceDto;
import com.bsuir.carservice.model.Service;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ServiceMapper {

    ServiceDto serviceToDto(Service service);
    Service dtoToService(ServiceDto serviceDto);
}
