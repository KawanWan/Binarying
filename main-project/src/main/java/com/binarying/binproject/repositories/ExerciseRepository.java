package com.binarying.binproject.repositories;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;
import com.binarying.binproject.entities.Exercise;
import java.util.List;


public interface ExerciseRepository extends ListCrudRepository<Exercise, Integer>{
    @Query("SELECT * FROM exercise WHERE phase_id = :phaseId")
    List<Exercise> findByPhase(Integer phaseId);

    @Query("SELECT * FROM exercise WHERE difficulty = :difficulty AND concept = :concept ORDER BY RANDOM() LIMIT :limit;")
    List<Exercise> findRandomConceptDifficulty(@Param("concept")String concept, @Param("difficulty")String difficulty, @Param("limit")int limit);
}
