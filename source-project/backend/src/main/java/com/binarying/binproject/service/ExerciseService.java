package com.binarying.binproject.service;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.binarying.binproject.entities.Exercise;
import com.binarying.binproject.repositories.ExerciseRepository;

@Service
public class ExerciseService {

    private final ExerciseRepository exerciseRepository;

    public ExerciseService(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    public List<Exercise> getRandomExercises(Integer phaseId) {
        List<Exercise> exercises = exerciseRepository.findByPhase(phaseId);
        Collections.shuffle(exercises);

        return exercises;
    }
    
}
