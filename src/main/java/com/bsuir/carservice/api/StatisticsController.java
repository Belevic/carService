package com.bsuir.carservice.api;

import com.bsuir.carservice.dto.PersonDto;
import com.bsuir.carservice.service.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/statistics")
public class StatisticsController {

    private final PersonService personService;

    public StatisticsController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public ResponseEntity<Map<String, Integer>> getAll() {
        return ResponseEntity.ok(personService.getManagerStatistics());
    }
}
