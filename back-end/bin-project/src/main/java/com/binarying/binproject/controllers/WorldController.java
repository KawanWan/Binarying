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

import com.binarying.binproject.entities.World;
import com.binarying.binproject.exceptions.DataNotFoundException;

import com.binarying.binproject.repositories.WorldRepository;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/world")
public class WorldController {

    private final WorldRepository worldRepository;

    public WorldController(WorldRepository worldRepository) {

        this.worldRepository = worldRepository;
    }

    @GetMapping("")
    List<World> findAll() {
        return worldRepository.findAll();
    }

    @GetMapping("/{id}")
    public World findById(@PathVariable Integer id) {
        Optional<World> world = worldRepository.findById(id);
        if (world.isEmpty()) {
            throw new DataNotFoundException();
        }
        return world.get();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    void create(@Valid @RequestBody World world) {
        worldRepository.save(world);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    void update(@Valid @RequestBody World world, @PathVariable Integer id) {
        worldRepository.save(world);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id) {
        worldRepository.delete(worldRepository.findById(id).get());

    }
}