package com.binarying.binproject.controllers;


import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.binarying.binproject.entities.Student;
import com.binarying.binproject.repositories.StudentRepository;
import com.binarying.binproject.service.StudentService;
import com.binarying.binproject.service.exceptions.StudentNotFoundException;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    private final StudentRepository studentRepository;
    private final StudentService studentService;

    public StudentController(StudentRepository studentRepository, StudentService studentService) {
        this.studentService = studentService;
        this.studentRepository = studentRepository;
    }

    @GetMapping("")
    List<Student> findAll() {
        return studentRepository.findAll();
    }

    @GetMapping("/{id}")
    public Student findById(@PathVariable Integer id) {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isEmpty()) {
            throw new StudentNotFoundException();
        }
        return student.get();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    void create(@Valid @RequestBody Student student) {
        studentRepository.save(student);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    void update(@Valid @RequestBody Student student, @PathVariable Integer id) {
        studentRepository.save(student);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}/increaselife")
    void increaseLife(@PathVariable Integer id) {
        studentService.increaseLife(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}/decreaselife")
    void decreaseLife(@PathVariable Integer id) {
        studentService.decreaseLife(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}/increaseexp") // http://localhost:8080/api/student/{id}/increaseexp?exp={ExpToAdd}
    void increaseExp(@PathVariable Integer id, @RequestParam Long exp) {
        studentService.increaseExp(id, exp);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}/addprogress")
    void addProgress(@PathVariable Integer id, @RequestParam Integer phase) {
        studentService.addProgress(id, phase);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id) {
        studentRepository.delete(studentRepository.findById(id).get());

    }
}