package com.binarying.binproject.entities;

import org.springframework.data.annotation.Id;

public record Universe(
        @Id Integer id,
        String name,
        String description,
        String[] colors
        
        ){}
