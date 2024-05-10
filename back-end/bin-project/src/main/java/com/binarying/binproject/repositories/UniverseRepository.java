package com.binarying.binproject.repositories;

import org.springframework.data.repository.ListCrudRepository;

import com.binarying.binproject.entities.Universe;

public interface UniverseRepository extends ListCrudRepository<Universe, Integer> {

}

/*
 * @PostConstruct
 * private void init() {
 * Colors coolors = new Colors(1,"#5382A1", "#FFFFFF")
 * universes.add(new Universe(1, "Java",
 * "Aprenda Java e conceitos de Orientação a Objetos.", coolors, new
 * ArrayList<>()));
 * 
 * universes.add(new Universe(2, "C++", "Aprenda C++", coolors, new
 * ArrayList<>()));
 * 
 * String[] coolorsPy = {"#F46036", "#1F271B"};
 * universes.add(new Universe(3, "Python",
 * "Explore a versatilidade da linguagem Python.", coolorsPy, new
 * ArrayList<>()));
 * 
 * String[] coolorsJs = {"#E63946", "#F1FAEE"};
 * universes.add(new Universe(4, "JavaScript",
 * "Descubra o poder do JavaScript no desenvolvimento web.", coolorsJs, new
 * ArrayList<>()));
 * }
 * }
 */
