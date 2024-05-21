package com.binarying.binproject.repositories;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.binarying.binproject.entities.Phase;
import java.util.List;

public interface PhaseRepository extends ListCrudRepository<Phase, Integer> {
    @Query("SELECT * FROM Phase WHERE world_id = :worldId")
    List<Phase> findByWorld(Integer worldId);

    List<Phase> findByConcept(String concept);

    List<Phase> findByConceptAndDifficulty(String concept, String difficulty);

    @Modifying
    @Transactional
    @Query("UPDATE Phase SET world_id = :worldId WHERE id = :phaseId")
    void setWorldId(@Param("phaseId") Integer phaseId, @Param("worldId") Integer worldId);
}

