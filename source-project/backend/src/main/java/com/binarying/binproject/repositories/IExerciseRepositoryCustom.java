package com.binarying.binproject.repositories;

import java.util.List;

import com.binarying.binproject.entities.Exercise;

public interface IExerciseRepositoryCustom {

    public List<Exercise> findByFilter(String concepts, String difficulty, Integer limit);
}