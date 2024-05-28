package com.binarying.binproject.repositories;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import com.binarying.binproject.entities.Exercise;

@Repository
public class ExerciseRepositoryCustom implements IExerciseRepositoryCustom{

    @Autowired
    private final JdbcClient jdbcClient;

    public ExerciseRepositoryCustom(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }
    
    @Override
    public List<Exercise> findByFilter(String concepts, String difficulty, Integer limit) {
        String sql = "SELECT * FROM exercise";
        Map<String, Object> params = new LinkedHashMap<>();

        if (concepts != null && !concepts.isEmpty()) {
            params.put("concept", concepts);
        }

        if (difficulty != null && !difficulty.isEmpty()) {
            params.put("difficulty", difficulty);
        }

        sql += " ORDER BY RANDOM()";

        if (limit != null) {
            sql += " LIMIT " + limit;
        }

        sql += ";";

        return jdbcClient.sql(sql).params(params).query(Exercise.class).list();
    }
}
