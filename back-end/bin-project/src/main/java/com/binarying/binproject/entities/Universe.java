package com.binarying.binproject.entities;

import java.util.List;

public record Universe(
    Integer id,
    String name,
    String description,
    String[] coolors,
    List<World> worlds
) {}
