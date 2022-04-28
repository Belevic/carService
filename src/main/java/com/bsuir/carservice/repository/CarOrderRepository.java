package com.bsuir.carservice.repository;

import com.bsuir.carservice.model.CarOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarOrderRepository extends JpaRepository<CarOrder, Long> {
}
