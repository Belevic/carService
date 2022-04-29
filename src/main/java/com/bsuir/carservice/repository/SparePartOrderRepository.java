package com.bsuir.carservice.repository;

import com.bsuir.carservice.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface SparePartOrderRepository extends JpaRepository<SparePartOrder, Long> {
    List<SparePartOrder> getAllByPersonOrderByIdAsc(Person person);
    List<SparePartOrder> getAllByManagerOrderByIdAsc(Person manager);

    @Query(value = """
            select ord from SparePartOrder ord
            where ord.date >= :startDate and ord.date <= :endDate
            and ord.status = :status
            and ord.closeReason = :closeReason
            """)
    List<SparePartOrder> getAllFilterByYear(Date startDate, Date endDate, Status status, CloseReason closeReason);
}
