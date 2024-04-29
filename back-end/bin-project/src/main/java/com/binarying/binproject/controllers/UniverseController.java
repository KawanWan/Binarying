package com.binarying.binproject.controllers;

import java.util.List;
import java.util.Optional;
import java.io.File;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

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

    @GetMapping("/{id}")
    Universe selectById(@PathVariable Integer id) {
        Optional<Universe> universe = universeRepository.selectById(id);

        if (universe.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return universe.get();
    }
    
}
