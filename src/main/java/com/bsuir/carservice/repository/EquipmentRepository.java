package com.bsuir.carservice.repository;

import com.bsuir.carservice.model.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipmentRepository extends JpaRepository<Equipment, Long> {
}
