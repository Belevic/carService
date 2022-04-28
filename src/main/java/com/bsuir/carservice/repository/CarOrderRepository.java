package com.bsuir.carservice.repository;

import com.bsuir.carservice.model.CarOrder;
import com.bsuir.carservice.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarOrderRepository extends JpaRepository<CarOrder, Long> {
    List<CarOrder> getAllByPersonOrderByIdAsc(Person person);
}
