package com.binarying.binproject.entities;

import org.springframework.data.annotation.Id;

import com.binarying.binproject.entities.enumerations.Difficulty;

public record Phase(
        @Id Integer id,
        String name,
        String description,
        String concept,
        Difficulty difficulty,
        Integer world_id
        
        ) {}
