package com.bsuir.carservice.repository;

import com.bsuir.carservice.model.Person;
import com.bsuir.carservice.model.Role;
import com.bsuir.carservice.model.ServiceOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface PersonRepository extends JpaRepository<Person, Long> {

    @Query(value = """
            select pe from Person pe
            inner join Account ac on pe.id = ac.id
            where ac.role = :role
            """)
    List<Person> getAllManagers(Role role);
}
