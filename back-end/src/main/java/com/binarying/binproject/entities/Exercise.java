package com.binarying.binproject.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import com.binarying.binproject.entities.enumerations.ExerciseType;

public record Exercise(
        @Id Integer id,
        String concept,
        @Column("exercisetype")ExerciseType exerciseType,
        String question,
        String[] answers,
        @Column("correctanswer")String correctAnswer,
        @Column("phase_id") Integer phaseId

) {
}
