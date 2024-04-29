package com.binarying.binproject.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.io.File;
import java.net.URISyntaxException;

import org.springframework.stereotype.Repository;
import com.binarying.binproject.entities.Universe;
import jakarta.annotation.PostConstruct;

@Repository
public class UniverseRepository {
    
    private List<Universe> universes = new ArrayList<>();
    
    public List<Universe> selectAll() {
        return universes;
    }

    public Optional<Universe> selectById(Integer id) {
        return universes.stream().filter(universe -> universe.id() == id).findFirst();
    }

    @PostConstruct
    private void init() {
        String[] coolors = {"#5382A1", "#FFFFFF"};
        universes.add(new Universe(1, "Java", "Aprenda Java e conceitos de Orientação a Objetos.", coolors, new ArrayList<>()));
        
        universes.add(new Universe(2, "C++", "Aprenda C++", coolors, new ArrayList<>()));

        String[] coolorsPy = {"#F46036", "#1F271B"};
        universes.add(new Universe(3, "Python", "Explore a versatilidade da linguagem Python.", coolorsPy, new ArrayList<>()));

        String[] coolorsJs = {"#E63946", "#F1FAEE"};
        universes.add(new Universe(4, "JavaScript", "Descubra o poder do JavaScript no desenvolvimento web.", coolorsJs, new ArrayList<>()));
    }
}
