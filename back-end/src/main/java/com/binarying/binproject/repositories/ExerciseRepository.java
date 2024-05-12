package com.binarying.binproject.repositories;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.binarying.binproject.entities.Exercise;

public interface ExerciseRepository extends ListCrudRepository<Exercise, Integer>{
    @Modifying
    @Transactional
    @Query("UPDATE exercise SET phase_id = :phaseId WHERE id = :exerciseId")
    void setPhaseId(@Param("exerciseId") Integer exerciseId, @Param("phaseId") Integer phaseId);
}
