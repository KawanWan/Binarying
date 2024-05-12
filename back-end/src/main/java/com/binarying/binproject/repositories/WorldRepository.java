package com.binarying.binproject.repositories;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.binarying.binproject.entities.World;

public interface WorldRepository extends ListCrudRepository<World, Integer> {
    @Modifying
    @Transactional
    @Query("UPDATE World SET universe_id = :universeId WHERE id = :worldId")
    void setUniverseId(@Param("worldId") Integer worldId, @Param("universeId") Integer UniverseId);
}
