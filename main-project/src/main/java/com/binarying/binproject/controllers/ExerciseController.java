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

import com.binarying.binproject.entities.Exercise;
import com.binarying.binproject.entities.Phase;

import com.binarying.binproject.exceptions.ExerciseNotFoundException;
import com.binarying.binproject.exceptions.PhaseNotFoundException;

import com.binarying.binproject.repositories.ExerciseRepository;
import com.binarying.binproject.repositories.PhaseRepository;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/exercise")
public class ExerciseController {

    private final ExerciseRepository exerciseRepository;
    private final PhaseRepository phaseRepository;

    public ExerciseController(ExerciseRepository exerciseRepository, PhaseRepository phaseRepository) {
        this.exerciseRepository = exerciseRepository;
        this.phaseRepository = phaseRepository;
    }

    @GetMapping("")
    List<Exercise> findAll() {
        return exerciseRepository.findAll();
    }

    @GetMapping("/{id}")
    public Exercise findById(@PathVariable Integer id) {
        Optional<Exercise> exercise = exerciseRepository.findById(id);
        if (exercise.isEmpty()) {
            throw new ExerciseNotFoundException();
        }
        return exercise.get();
    }

    @GetMapping("/random")  // Example ---> http://localhost:8080/api/exercise/random?concept={concept}&difficulty={difficulty}&limit={limit}
    public List<Exercise> findRandomConceptDifficulty(@RequestParam String concept, @RequestParam String difficulty, @RequestParam Integer limit){
        return exerciseRepository.findRandomConceptDifficulty(concept, difficulty, limit);
    }
    

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    void create(@Valid @RequestBody Exercise exercise) {
        exerciseRepository.save(exercise);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    void update(@Valid @RequestBody Exercise exercise, @PathVariable Integer id) {
        exerciseRepository.save(exercise);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/setphase/{id}") // Example --> http://localhost:8080/api/exercise/setexercise/{id}?phaseId={phaseId}
    public void setPhase(@PathVariable Integer id, @RequestParam Integer phaseId) {

        Optional<Exercise> optExercise = exerciseRepository.findById(id);
        Optional<Phase> optPhase = phaseRepository.findById(phaseId);

        if (optExercise.isEmpty()) {
            throw new ExerciseNotFoundException();
        }
        if (optPhase.isEmpty()) {
            throw new PhaseNotFoundException();
        }

        exerciseRepository.setPhaseId(id, phaseId);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id) {
        exerciseRepository.delete(exerciseRepository.findById(id).get());

    }
}
