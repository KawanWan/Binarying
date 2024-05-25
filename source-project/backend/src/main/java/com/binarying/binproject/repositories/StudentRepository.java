package com.binarying.binproject.repositories;

import org.springframework.data.repository.ListCrudRepository;

import com.binarying.binproject.entities.Student;

public interface StudentRepository extends ListCrudRepository<Student, Integer>{

}
