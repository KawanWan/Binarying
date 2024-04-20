package com.binarying.binproject.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import com.binarying.binproject.entities.Universe;
import jakarta.annotation.PostConstruct;

@Repository
public class UniverseRepository {
    
    private List<Universe> universes = new ArrayList<>();

    
    public List<Universe> selectAll() {
        return universes;
    }

    @PostConstruct
    private void init() {
        String[] coolors = {"#5382A1", "#FFFFFF"};
        universes.add(new Universe(1, "Java", "Aprenda Java e conceitos de Orientação a Objetos.", coolors, new ArrayList<>()));
    }
}
