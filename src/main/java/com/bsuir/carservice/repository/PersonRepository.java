package com.bsuir.carservice.repository;

import com.bsuir.carservice.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Map;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
