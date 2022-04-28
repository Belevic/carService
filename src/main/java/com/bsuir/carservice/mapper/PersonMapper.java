package com.bsuir.carservice.mapper;


import com.bsuir.carservice.dto.PersonDto;
import com.bsuir.carservice.model.Person;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface PersonMapper {

    PersonDto personToDto(Person person);
    Person dtoToPerson(PersonDto personDto);
}