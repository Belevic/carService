package com.bsuir.carservice.api;

import com.bsuir.carservice.dto.OrderDto;
import com.bsuir.carservice.dto.ServiceOrderDto;
import com.bsuir.carservice.dto.SparePartOrderDto;
import com.bsuir.carservice.service.ServiceOrderService;
import com.bsuir.carservice.service.SparePartOrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@CrossOrigin
@RestController
@RequestMapping("/spare-part-order")
public class SparePartOrderController {

    private final SparePartOrderService sparePartOrderService;

    public SparePartOrderController(SparePartOrderService sparePartOrderService) {
        this.sparePartOrderService = sparePartOrderService;
    }

    @PostMapping("/save")
    public ResponseEntity<SparePartOrderDto> save(@RequestBody OrderDto orderDto) {
        return Objects.isNull(orderDto) ? ResponseEntity.badRequest().build() :
                ResponseEntity.ok(sparePartOrderService.save(orderDto));
    }

    @PutMapping("/update")
    public ResponseEntity<SparePartOrderDto> update(@RequestBody OrderDto orderDto) {
        return Objects.isNull(orderDto) ? ResponseEntity.badRequest().build() :
                ResponseEntity.ok(sparePartOrderService.update(orderDto));
    }

    @GetMapping
    public ResponseEntity<List<SparePartOrderDto>> getAll() {
        return ResponseEntity.ok(sparePartOrderService.getAll());
    }
}
