package com.intego.mts.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class EntityUniquenessConstraintViolationException extends RuntimeException{

    public EntityUniquenessConstraintViolationException(String message) {
        super(message);
    }
}
