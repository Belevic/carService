package com.bsuir.carservice.service;

import com.bsuir.carservice.dto.PersonDto;
import com.bsuir.carservice.mapper.PersonMapper;
import com.bsuir.carservice.model.Person;
import com.bsuir.carservice.repository.PersonRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Tuple;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class PersonService {

    @PersistenceContext
    EntityManager entityManager;

    private final PersonRepository personRepository;
    private final PersonMapper personMapper;

    public PersonService(PersonRepository personRepository, PersonMapper personMapper) {
        this.personRepository = personRepository;
        this.personMapper = personMapper;
    }

    public Map<String, Integer> getManagerStatistics() {
        Map<String, Integer> managerMap = new HashMap<>();
        List<Object[]> list = entityManager
                .createNativeQuery(
                        "select tab.mi as manager, count(tab.mi) as summ from " +
                        "(select cd.manager_id as mi, count(*) as co from car_order as cd where cd.status = 'ENDED' " +
                        "and cd.close_reason = 'SUCCESS' group by mi UNION ALL " +
                        "select sd.manager_id as mi, count(*) as co from service_order as sd " +
                        "where sd.status = 'ENDED' and sd.close_reason = 'SUCCESS' group by mi UNION ALL " +
                        "select spd.manager_id as mi, count(*) as co from spare_part_order as spd " +
                        "where spd.status = 'ENDED' and spd.close_reason = 'SUCCESS' group by mi) tab group by manager")
                .getResultList();

        for (Object[] result : list) {
            Person person = personRepository.getById(((BigInteger) result[1]).longValue());
            String fio = person.getLastName() + " " + person.getFirstName() + " " + person.getMiddleName();
            managerMap.put(fio, ((BigInteger) result[1]).intValue());
        }
        return managerMap;
    }
}
