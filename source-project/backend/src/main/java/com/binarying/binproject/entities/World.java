package com.binarying.binproject.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
  

public record World(
    @Id
    Integer id,
    String name,
    String description,
    @Column("universe_id")
    Integer universeId
) {}
