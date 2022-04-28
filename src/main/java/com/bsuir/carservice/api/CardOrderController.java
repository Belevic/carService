package com.bsuir.carservice.api;


import com.bsuir.carservice.dto.CarOrderDto;
import com.bsuir.carservice.dto.EquipmentDto;
import com.bsuir.carservice.dto.OrderDto;
import com.bsuir.carservice.service.CarOrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@CrossOrigin
@RestController
@RequestMapping("/car-order")
public class CardOrderController {

    private final CarOrderService carOrderService;

    public CardOrderController(CarOrderService carOrderService) {
        this.carOrderService = carOrderService;
    }

    @PostMapping("/save")
    public ResponseEntity<CarOrderDto> save(@RequestBody OrderDto orderDto) {
        return Objects.isNull(orderDto) ? ResponseEntity.badRequest().build() :
                ResponseEntity.ok(carOrderService.save(orderDto));
    }

    @PutMapping("/update")
    public ResponseEntity<CarOrderDto> update(@RequestBody OrderDto orderDto) {
        return Objects.isNull(orderDto) ? ResponseEntity.badRequest().build() :
                ResponseEntity.ok(carOrderService.update(orderDto));
    }

    @GetMapping
    public ResponseEntity<List<CarOrderDto>> getAll(@RequestParam Long id) {
        return ResponseEntity.ok(carOrderService.getAllByPerson(id));
    }
}
