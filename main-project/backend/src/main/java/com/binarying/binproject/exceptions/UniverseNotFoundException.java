package com.binarying.binproject.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.NOT_FOUND)
public class UniverseNotFoundException extends RuntimeException {
    public UniverseNotFoundException() {
        super("Universe Not Found!");
    }
}