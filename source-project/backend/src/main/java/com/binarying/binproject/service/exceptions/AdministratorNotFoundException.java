package com.binarying.binproject.service.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;



@ResponseStatus(HttpStatus.NOT_FOUND)
public class AdministratorNotFoundException extends RuntimeException {
    public AdministratorNotFoundException() {
        super("Administrator Not Found!");
    }
}