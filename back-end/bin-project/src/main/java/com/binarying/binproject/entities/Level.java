package com.binarying.binproject.entities;

import java.util.List;

public record Level(
    Integer id,
    String name,
    String concept,
    List<Exercise> exercises
) {}
