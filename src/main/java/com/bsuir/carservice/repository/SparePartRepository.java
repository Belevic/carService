package com.bsuir.carservice.repository;

import com.bsuir.carservice.model.SparePart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SparePartRepository extends JpaRepository<SparePart, Long> {
}
