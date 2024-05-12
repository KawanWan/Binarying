package com.binarying.binproject.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.binarying.binproject.entities.Universe;
import com.binarying.binproject.entities.World;
import com.binarying.binproject.exceptions.UniverseNotFoundException;
import com.binarying.binproject.exceptions.WorldNotFoundException;
import com.binarying.binproject.repositories.UniverseRepository;
import com.binarying.binproject.repositories.WorldRepository;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/world")
public class WorldController {

    private final UniverseRepository universeRepository;
    private final WorldRepository worldRepository;

    public WorldController(WorldRepository worldRepository, UniverseRepository universeRepository) {
        this.universeRepository = universeRepository;
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
            throw new WorldNotFoundException();
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
    @PutMapping("/setuniverse/{id}") // Example --> http://localhost:8080/api/world/setuniverse/{id}?universeId={universeId}
    public void setUniverse(@PathVariable Integer id, @RequestParam Integer universeId) {

        Optional<Universe> optUniverse = universeRepository.findById(universeId);
        Optional<World> optWorld = worldRepository.findById(id);

        if (optUniverse.isEmpty()) {
            throw new UniverseNotFoundException();
        }
        if (optWorld.isEmpty()) {
            throw new WorldNotFoundException();
        }

        worldRepository.setUniverseId(id, universeId);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id) {
        worldRepository.delete(worldRepository.findById(id).get());
    }
}