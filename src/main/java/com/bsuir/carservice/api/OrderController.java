package com.bsuir.carservice.api;

import com.bsuir.carservice.dto.OrdersDto;
import com.bsuir.carservice.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Objects;

@CrossOrigin
@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public ResponseEntity<OrdersDto> getAll(@RequestParam(required = false) Long id) {
        return Objects.nonNull(id) ? ResponseEntity.ok(orderService.getAllByPerson(id)) : ResponseEntity.ok(orderService.getAll());
    }

    @GetMapping("/year")
    public ResponseEntity<OrdersDto> getAllFilterByYear(@RequestParam Long year) throws ParseException {
        return ResponseEntity.ok(orderService.getAllFilterByYear(year));
    }

    @GetMapping("/manager")
    public ResponseEntity<OrdersDto> getAllFilterByManager(@RequestParam Long id) {
        return ResponseEntity.ok(orderService.getAllFilterByManager(id));
    }
}
