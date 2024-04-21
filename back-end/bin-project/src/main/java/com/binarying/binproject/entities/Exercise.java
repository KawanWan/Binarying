package com.binarying.binproject.entities;

import com.binarying.binproject.entities.enumerations.ExerciseType;

public record Exercise(
    Integer id,
    String concept,
    ExerciseType exerciseType
) {}
