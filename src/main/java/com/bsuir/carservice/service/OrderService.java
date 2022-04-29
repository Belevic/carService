package com.bsuir.carservice.service;

import com.bsuir.carservice.dto.OrdersDto;
import com.bsuir.carservice.mapper.CarOrderMapper;
import com.bsuir.carservice.mapper.ServiceOrderMapper;
import com.bsuir.carservice.mapper.SparePartOrderMapper;
import com.bsuir.carservice.model.CloseReason;
import com.bsuir.carservice.model.Person;
import com.bsuir.carservice.model.Status;
import com.bsuir.carservice.repository.CarOrderRepository;
import com.bsuir.carservice.repository.PersonRepository;
import com.bsuir.carservice.repository.ServiceOrderRepository;
import com.bsuir.carservice.repository.SparePartOrderRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private static final String START_YEAR_STR = "-01-01";
    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    private final CarOrderRepository carOrderRepository;
    private final ServiceOrderRepository serviceOrderRepository;
    private final SparePartOrderRepository sparePartOrderRepository;
    private final PersonRepository personRepository;
    private final CarOrderMapper carOrderMapper;
    private final ServiceOrderMapper serviceOrderMapper;
    private final SparePartOrderMapper sparePartOrderMapper;

    public OrderService(CarOrderRepository carOrderRepository, ServiceOrderRepository serviceOrderRepository,
                        SparePartOrderRepository sparePartOrderRepository, PersonRepository personRepository,
                        CarOrderMapper carOrderMapper, ServiceOrderMapper serviceOrderMapper,
                        SparePartOrderMapper sparePartOrderMapper) {
        this.carOrderRepository = carOrderRepository;
        this.serviceOrderRepository = serviceOrderRepository;
        this.sparePartOrderRepository = sparePartOrderRepository;
        this.personRepository = personRepository;
        this.carOrderMapper = carOrderMapper;
        this.serviceOrderMapper = serviceOrderMapper;
        this.sparePartOrderMapper = sparePartOrderMapper;
    }

    public OrdersDto getAllByPerson(Long personId) {
        Person person = personRepository.getById(personId);
        OrdersDto ordersDto = new OrdersDto();

        ordersDto.setCarOrders(carOrderRepository.getAllByPersonOrderByIdAsc(person).stream().map(carOrderMapper::carOrderToDto).collect(Collectors.toList()));
        ordersDto.setServiceOrders(serviceOrderRepository.getAllByPersonOrderByIdAsc(person).stream().map(serviceOrderMapper::serviceOrderToDto).collect(Collectors.toList()));
        ordersDto.setSparePartOrders(sparePartOrderRepository.getAllByPersonOrderByIdAsc(person).stream().map(sparePartOrderMapper::sparePartOrderToDto).collect(Collectors.toList()));
        return ordersDto;
    }

    public OrdersDto getAll() {
        OrdersDto ordersDto = new OrdersDto();

        ordersDto.setCarOrders(carOrderRepository.findAll().stream().map(carOrderMapper::carOrderToDto).collect(Collectors.toList()));
        ordersDto.setServiceOrders(serviceOrderRepository.findAll().stream().map(serviceOrderMapper::serviceOrderToDto).collect(Collectors.toList()));
        ordersDto.setSparePartOrders(sparePartOrderRepository.findAll().stream().map(sparePartOrderMapper::sparePartOrderToDto).collect(Collectors.toList()));
        return ordersDto;
    }

    public OrdersDto getAllFilterByYear(Long year) throws ParseException {
        Date startDate = simpleDateFormat.parse(year + START_YEAR_STR);
        Date endDate = simpleDateFormat.parse((year + 1) + START_YEAR_STR);

        OrdersDto ordersDto = new OrdersDto();

        ordersDto.setCarOrders(carOrderRepository.getAllFilterByYear(startDate, endDate, Status.ENDED, CloseReason.SUCCESS).stream().map(carOrderMapper::carOrderToDto).collect(Collectors.toList()));
        ordersDto.setServiceOrders(serviceOrderRepository.getAllFilterByYear(startDate, endDate, Status.ENDED, CloseReason.SUCCESS).stream().map(serviceOrderMapper::serviceOrderToDto).collect(Collectors.toList()));
        ordersDto.setSparePartOrders(sparePartOrderRepository.getAllFilterByYear(startDate, endDate, Status.ENDED, CloseReason.SUCCESS).stream().map(sparePartOrderMapper::sparePartOrderToDto).collect(Collectors.toList()));
        return ordersDto;
    }

    public OrdersDto getAllFilterByManager(Long managerId) {
        Person manager = personRepository.getById(managerId);
        OrdersDto ordersDto = new OrdersDto();

        ordersDto.setCarOrders(carOrderRepository.getAllByManagerOrderByIdAsc(manager).stream().map(carOrderMapper::carOrderToDto).collect(Collectors.toList()));
        ordersDto.setServiceOrders(serviceOrderRepository.getAllByManagerOrderByIdAsc(manager).stream().map(serviceOrderMapper::serviceOrderToDto).collect(Collectors.toList()));
        ordersDto.setSparePartOrders(sparePartOrderRepository.getAllByManagerOrderByIdAsc(manager).stream().map(sparePartOrderMapper::sparePartOrderToDto).collect(Collectors.toList()));
        return ordersDto;
    }
}
