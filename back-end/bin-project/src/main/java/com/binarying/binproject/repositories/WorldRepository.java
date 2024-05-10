package com.binarying.binproject.repositories;

import org.springframework.data.repository.ListCrudRepository;
import com.binarying.binproject.entities.World;

public interface WorldRepository extends ListCrudRepository<World, Integer> {

}
