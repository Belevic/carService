package com.bsuir.carservice.api;

import com.bsuir.carservice.dto.OrdersDto;
import com.bsuir.carservice.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public ResponseEntity<OrdersDto> getAll(@RequestParam Long id) {
        return ResponseEntity.ok(orderService.getAllByPerson(id));
    }
}
