package com.binarying.binproject.entities;

import org.springframework.data.annotation.Id;
  

public record World(
    @Id
    Integer id,
    String name,
    String description,
    Integer universe_id
) {}
