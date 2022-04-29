package com.bsuir.carservice.api;

import com.bsuir.carservice.dto.CarOrderDto;
import com.bsuir.carservice.dto.OrderDto;
import com.bsuir.carservice.dto.ServiceOrderDto;
import com.bsuir.carservice.service.CarOrderService;
import com.bsuir.carservice.service.ServiceOrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.Objects;

@CrossOrigin
@RestController
@RequestMapping("/service-order")
public class ServiceOrderController {

    private final ServiceOrderService serviceOrderService;

    public ServiceOrderController(ServiceOrderService serviceOrderService) {
        this.serviceOrderService = serviceOrderService;
    }

    @PostMapping("/save")
    public ResponseEntity<ServiceOrderDto> save(@RequestBody OrderDto orderDto) throws ParseException {
        return Objects.isNull(orderDto) ? ResponseEntity.badRequest().build() :
                ResponseEntity.ok(serviceOrderService.save(orderDto));
    }

    @PutMapping("/update")
    public ResponseEntity<ServiceOrderDto> update(@RequestBody OrderDto orderDto) throws ParseException {
        return Objects.isNull(orderDto) ? ResponseEntity.badRequest().build() :
                ResponseEntity.ok(serviceOrderService.update(orderDto));
    }

    @GetMapping
    public ResponseEntity<List<ServiceOrderDto>> getAllById(@RequestParam Long id) {
        return ResponseEntity.ok(serviceOrderService.getAllByPerson(id));
    }
}
