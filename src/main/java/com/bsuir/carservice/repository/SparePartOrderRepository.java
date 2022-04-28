package com.bsuir.carservice.repository;

import com.bsuir.carservice.model.Person;
import com.bsuir.carservice.model.ServiceOrder;
import com.bsuir.carservice.model.SparePartOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SparePartOrderRepository extends JpaRepository<SparePartOrder, Long> {
    List<SparePartOrder> getAllByPersonOrderByIdAsc(Person person);
}
