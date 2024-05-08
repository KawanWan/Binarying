package com.binarying.binproject.entities;

import java.util.Map;

import com.binarying.binproject.entities.enumerations.ExerciseType;

public record Exercise(
    Integer id,
    String concept,
    ExerciseType exerciseType,
    Map<String, Boolean> answers 
) {}
