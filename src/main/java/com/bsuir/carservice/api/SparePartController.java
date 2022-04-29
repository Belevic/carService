package com.bsuir.carservice.api;

import com.bsuir.carservice.dto.SparePartDto;
import com.bsuir.carservice.service.SparePartService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/spare-part")
public class SparePartController {

    private final SparePartService sparePartService;

    public SparePartController(SparePartService sparePartService) {
        this.sparePartService = sparePartService;
    }



    @GetMapping
    public ResponseEntity<List<SparePartDto>> getAll() {
        return ResponseEntity.ok(sparePartService.getAll());
    }
}
