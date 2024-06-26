package com.binarying.binproject.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.binarying.binproject.entities.Phase;
import com.binarying.binproject.entities.Student;
import com.binarying.binproject.repositories.PhaseRepository;
import com.binarying.binproject.repositories.StudentRepository;
import com.binarying.binproject.service.exceptions.PhaseAlreadyAddedException;
import com.binarying.binproject.service.exceptions.PhaseNotFoundException;
import com.binarying.binproject.service.exceptions.StudentNotFoundException;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final PhaseRepository phaseRepository;

    public StudentService(StudentRepository studentRepository, PhaseRepository phaseRepository) {
        this.studentRepository = studentRepository;
        this.phaseRepository = phaseRepository;
    }

    @Transactional
    public void increaseLife(Integer studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new StudentNotFoundException());
        if (student.getLife() < 5) {
            student.increaseLife();
            studentRepository.save(student);
        }
    }

    @Transactional
    public void decreaseLife(Integer studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new StudentNotFoundException());
        if (student.getLife() > 0) {
            student.decreaseLife();
            studentRepository.save(student);
        }
    }

    @Transactional
    public void increaseExp(Integer studentId, Long expToAdd) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new StudentNotFoundException());
        student.increaseExp(expToAdd);
        studentRepository.save(student);
    }

    @Transactional
    public void addProgress(Integer studentId, int newProgress) {
        Optional<Phase> optPhase = phaseRepository.findById(newProgress);
        if (optPhase.isEmpty()) {
            throw new PhaseNotFoundException();
        }
        
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new StudentNotFoundException());

        for(int i = 0; i < student.getProgress().length; i++) {
            if (student.getProgress()[i] == newProgress) {
                throw new PhaseAlreadyAddedException(studentId);
            }
        }
        student.addProgress(newProgress);
        studentRepository.save(student);
    }

}
