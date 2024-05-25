package com.binarying.binproject.service.exceptions;

public class PhaseAlreadyAddedException extends RuntimeException {
    public PhaseAlreadyAddedException(Integer id) {
        super("Phase progress already added. Student id: " + id);
    }
}
