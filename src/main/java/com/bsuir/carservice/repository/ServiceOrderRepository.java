package com.bsuir.carservice.repository;

import com.bsuir.carservice.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface ServiceOrderRepository extends JpaRepository<ServiceOrder, Long> {
    List<ServiceOrder> getAllByPersonOrderByIdAsc(Person person);
    List<ServiceOrder> getAllByManagerOrderByIdAsc(Person manager);

    @Query(value = """
            select ord from ServiceOrder ord
            where ord.date >= :startDate and ord.date <= :endDate
            and ord.status = :status 
            and ord.closeReason = :closeReason
            """)
    List<ServiceOrder> getAllFilterByYear(Date startDate, Date endDate, Status status, CloseReason closeReason);
}
