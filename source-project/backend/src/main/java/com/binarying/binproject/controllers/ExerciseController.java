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
import com.binarying.binproject.repositories.ExerciseRepository;
import com.binarying.binproject.repositories.ExerciseRepositoryCustom;
import com.binarying.binproject.repositories.IExerciseRepositoryCustom;
import com.binarying.binproject.service.exceptions.ExerciseNotFoundException;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/exercise")
public class ExerciseController {

    private final ExerciseRepository exerciseRepository;
    private final IExerciseRepositoryCustom exerciseRepositoryCustom;

    public ExerciseController(ExerciseRepository exerciseRepository, ExerciseRepositoryCustom exerciseRepositoryCustom) {
        this.exerciseRepository = exerciseRepository;
        this.exerciseRepositoryCustom = exerciseRepositoryCustom;
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

    @GetMapping("/random")
    public List<Exercise> findByConceptAndDifficulty(@RequestParam(required = false) String concept, @RequestParam(required = false) String difficulty, @RequestParam(required = false) Integer limit){
        return exerciseRepositoryCustom.findByFilter(concept, difficulty, limit);
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
    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id) {
        Optional<Exercise> exercise = exerciseRepository.findById(id);
        if (exercise.isEmpty()) {
            throw new ExerciseNotFoundException();
        }
        exerciseRepository.delete(exerciseRepository.findById(id).get());

    }
}
