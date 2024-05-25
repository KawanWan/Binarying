package com.binarying.binproject.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.binarying.binproject.entities.Phase;
import com.binarying.binproject.entities.World;
import com.binarying.binproject.repositories.PhaseRepository;
import com.binarying.binproject.repositories.WorldRepository;
import com.binarying.binproject.service.PhaseService;
import com.binarying.binproject.service.exceptions.PhaseNotFoundException;
import com.binarying.binproject.service.exceptions.WorldNotFoundException;

import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

@RestController
@RequestMapping("/api/phase")
public class PhaseController {

    private final WorldRepository worldRepository;
    private final PhaseRepository phaseRepository;
    private final PhaseService phaseService;

    public PhaseController(PhaseRepository phaseRepository, WorldRepository worldRepository, PhaseService phaseService) {
        this.phaseRepository = phaseRepository;
        this.worldRepository = worldRepository;
        this.phaseService = phaseService;
    }

    @GetMapping("")
    List<Phase> findAll(@RequestParam(required = false) Integer worldId) {
        if (worldId == null)
            return phaseRepository.findAll();
        return phaseRepository.findByWorld(worldId);
    }

    @GetMapping("/{id}")
    Phase findById(@PathVariable Integer id) {
        Optional<Phase> phase = phaseRepository.findById(id);
        if (phase.isEmpty()) {
            throw new PhaseNotFoundException();
        }
        return phase.get();
    }

    @GetMapping("/concept/{concept}")
    List<Phase> findByConcept(@PathVariable String concept) {
        return phaseRepository.findByConcept(concept);
    }

    @GetMapping("/concept/{concept}/difficulty/{difficulty}")
    List<Phase> findByConceptAndDifficulty(@PathVariable String concept, @PathVariable String difficulty) {
        return phaseRepository.findByConceptAndDifficulty(concept, difficulty);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    void create(@Valid @RequestBody Phase phase) {
        phaseRepository.save(phase);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/createall")
    void createAll(@Valid @RequestBody List<Phase> phases) {
        phaseRepository.saveAll(phases);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    void update(@Valid @RequestBody Phase phase, @PathVariable Integer id) {
        phaseRepository.save(phase);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/setworld/{id}") // Example --> http://localhost:8080/api/phase/setworld/{id}?worldId={worldId}
    public void setWorld(@PathVariable Integer id, @RequestParam Integer worldId) {

        Optional<World> optWorld = worldRepository.findById(worldId);
        Optional<Phase> optPhase = phaseRepository.findById(id);

        if (optWorld.isEmpty()) {
            throw new WorldNotFoundException();
        }
        if (optPhase.isEmpty()) {
            throw new PhaseNotFoundException();
        }

        phaseRepository.setWorldId(id, worldId);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id) {
        Optional<Phase> optPhase = phaseRepository.findById(id);
        if (optPhase.isEmpty()) {
            throw new PhaseNotFoundException();
        }
        phaseRepository.delete(phaseRepository.findById(id).get());
    }

    @GetMapping("/arrayMap/{worldId}")
    public Integer[][] getMap(@PathVariable Integer worldId) {
        return phaseService.getPhasesMap(worldId);
    }
}
