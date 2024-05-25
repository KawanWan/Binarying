package com.binarying.binproject.controllers.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.binarying.binproject.service.exceptions.AdministratorNotFoundException;
import com.binarying.binproject.service.exceptions.ExerciseNotFoundException;
import com.binarying.binproject.service.exceptions.PhaseAlreadyAddedException;
import com.binarying.binproject.service.exceptions.PhaseNotFoundException;
import com.binarying.binproject.service.exceptions.StudentNotFoundException;
import com.binarying.binproject.service.exceptions.UniverseNotFoundException;
import com.binarying.binproject.service.exceptions.WorldNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(PhaseAlreadyAddedException.class)
    public ResponseEntity<StandardError> responseEntity(PhaseAlreadyAddedException e, HttpServletRequest request) {
        String error = "Phase already added";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err); 
    }

    @ExceptionHandler(UniverseNotFoundException.class)
    public ResponseEntity<StandardError> database(UniverseNotFoundException e, HttpServletRequest request) {
        String error = "Universe not Found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err); 
    }
    @ExceptionHandler(WorldNotFoundException.class)
    public ResponseEntity<StandardError> database(WorldNotFoundException e, HttpServletRequest request) {
        String error = "World not Found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err); 
    }
    @ExceptionHandler(PhaseNotFoundException.class)
    public ResponseEntity<StandardError> database(PhaseNotFoundException e, HttpServletRequest request) {
        String error = "Phase not Found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err); 
    }
    @ExceptionHandler(ExerciseNotFoundException.class)
    public ResponseEntity<StandardError> database(ExerciseNotFoundException e, HttpServletRequest request) {
        String error = "Exercise not Found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err); 
    }

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<StandardError> database(StudentNotFoundException e, HttpServletRequest request) {
        String error = "Student not Found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err); 
    }

    @ExceptionHandler(AdministratorNotFoundException.class)
    public ResponseEntity<StandardError> database(AdministratorNotFoundException e, HttpServletRequest request) {
        String error = "Administrator not Found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err); 
    }
}