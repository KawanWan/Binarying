package com.binarying.binproject.entities;

import java.util.List;

public record World(
    Integer id,
    String name,
    String description,
    List<Phase> phases
) {}
