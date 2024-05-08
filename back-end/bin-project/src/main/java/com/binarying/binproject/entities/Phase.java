package com.binarying.binproject.entities;

import java.util.List;

import com.binarying.binproject.entities.enumerations.Difficulty;

public record Phase(
    Integer id,
    String name,
    String concept,
    Difficulty difficulty,
    List<Exercise> exercises
) {}
