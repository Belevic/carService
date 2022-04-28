package com.bsuir.carservice.service;


import com.bsuir.carservice.dto.SparePartDto;
import com.bsuir.carservice.mapper.SparePartMapper;
import com.bsuir.carservice.repository.SparePartRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SparePartService {

    private final SparePartRepository sparePartRepository;
    private final SparePartMapper sparePartMapper;

    public SparePartService(SparePartRepository sparePartRepository, SparePartMapper sparePartMapper) {
        this.sparePartRepository = sparePartRepository;
        this.sparePartMapper = sparePartMapper;
    }

    public List<SparePartDto> getAll() {
        return sparePartRepository.findAll().stream().map(sparePartMapper::sparePartToDto).collect(Collectors.toList());
    }
}
