package com.binarying.binproject.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import com.binarying.binproject.entities.enumerations.Difficulty;

public record Phase(
        @Id Integer id,
        String name,
        String description,
        String concept,
        Difficulty difficulty,
        Integer x,
        Integer y,
        @Column("world_id") Integer worldId
        
        ) {}
