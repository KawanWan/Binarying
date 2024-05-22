package com.binarying.binproject.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.binarying.binproject.entities.Universe;
import com.binarying.binproject.exceptions.UniverseNotFoundException;
import com.binarying.binproject.repositories.UniverseRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/universe")
public class UniverseController {

    private final UniverseRepository universeRepository;

    public UniverseController(UniverseRepository universeRepository) {

        this.universeRepository = universeRepository;
    }

    @GetMapping("")
    List<Universe> findAll() {
        return universeRepository.findAll();
    }

    @GetMapping("/{id}")
    public Universe findById(@PathVariable Integer id) {
        Optional<Universe> universe = universeRepository.findById(id);
        if (universe.isEmpty()) {
            throw new UniverseNotFoundException();
        }
        return universe.get();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    void create(@Valid @RequestBody Universe universe) {
        universeRepository.save(universe);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    void update(@Valid @RequestBody Universe universe, @PathVariable Integer id) {
        universeRepository.save(universe);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id) {
        universeRepository.delete(universeRepository.findById(id).get());

    }
}