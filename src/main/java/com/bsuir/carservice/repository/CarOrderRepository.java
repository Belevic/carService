package com.bsuir.carservice.repository;

import com.bsuir.carservice.model.CarOrder;
import com.bsuir.carservice.model.CloseReason;
import com.bsuir.carservice.model.Person;
import com.bsuir.carservice.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface CarOrderRepository extends JpaRepository<CarOrder, Long> {
    List<CarOrder> getAllByPersonOrderByIdAsc(Person person);
    List<CarOrder> getAllByManagerOrderByIdAsc(Person manager);

    @Query(value = """
            select ord from CarOrder ord
            where ord.date >= :startDate and ord.date <= :endDate
            and ord.status = :status
            and ord.closeReason = :closeReason
            """)
    List<CarOrder> getAllFilterByYear(Date startDate, Date endDate, Status status, CloseReason closeReason);
}
