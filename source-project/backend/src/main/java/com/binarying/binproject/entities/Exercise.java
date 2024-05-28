package com.binarying.binproject.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import com.binarying.binproject.entities.enumerations.Difficulty;
import com.binarying.binproject.entities.enumerations.ExerciseType;

public record Exercise(
        @Id Integer id,
        String concept,
        @Column("exercise_type")
        ExerciseType exerciseType,
        Difficulty difficulty,
        String question,
        String answers,
        @Column("correct_answer_index")
        Integer correctAnswerIndex,
        @Column("code-example")
        String codeExample
) {}
