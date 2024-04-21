package com.binarying.binproject.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.binarying.binproject.entities.Universe;
import com.binarying.binproject.repositories.UniverseRepository;

@RestController
@RequestMapping("/api/universes")
public class UniverseController {
    
    private final UniverseRepository universeRepository;

    public UniverseController(UniverseRepository universeRepository) {
        this.universeRepository = universeRepository;
    }

    @GetMapping("")
    List<Universe> selectAll() {
        return universeRepository.selectAll();
    }
}
