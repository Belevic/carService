package com.bsuir.carservice.api;

import com.bsuir.carservice.dto.CarOrderDto;
import com.bsuir.carservice.dto.ManagerDto;
import com.bsuir.carservice.dto.OrderDto;
import com.bsuir.carservice.dto.PersonDto;
import com.bsuir.carservice.service.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@CrossOrigin
@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("/save")
    public ResponseEntity<CarOrderDto> save(@RequestBody ManagerDto managerDto) {
        if (Objects.isNull(managerDto)) {
            return ResponseEntity.badRequest().build();
        }
        personService.save(managerDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/managers")
    public ResponseEntity<List<PersonDto>> getAllManagers() {
        return ResponseEntity.ok(personService.getAllManagers());
    }
}
