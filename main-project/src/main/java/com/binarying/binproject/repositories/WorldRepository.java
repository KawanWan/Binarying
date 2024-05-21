package com.binarying.binproject.repositories;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import com.binarying.binproject.entities.World;

public interface WorldRepository extends ListCrudRepository<World, Integer> {

    @Query("SELECT * FROM world WHERE universe_id = :universeId")
    public List<World> findAllByUniverseId(Integer universeId);
}
