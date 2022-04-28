package com.bsuir.carservice.api;

import com.bsuir.carservice.dto.ServiceDto;
import com.bsuir.carservice.service.CarService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/service")
public class ServiceController {

    private final CarService carService;

    public ServiceController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public ResponseEntity<List<ServiceDto>> getAll() {
        return ResponseEntity.ok(carService.getAll());
    }
}
