package com.bsuir.carservice.repository;

import com.bsuir.carservice.model.CarOrder;
import com.bsuir.carservice.model.Person;
import com.bsuir.carservice.model.ServiceOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServiceOrderRepository extends JpaRepository<ServiceOrder, Long> {
    List<ServiceOrder> getAllByPersonOrderByIdAsc(Person person);
}
