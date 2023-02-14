package com.intego.mts.exception;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;

@ControllerAdvice
public class ExceptionHandlingControllerAdvice {
    @ResponseBody
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ViolationResponse onConstraintValidationException(ConstraintViolationException e) {

        return new ViolationResponse(LocalDateTime.now(), String.valueOf(HttpStatus.BAD_REQUEST.value()), HttpStatus.BAD_REQUEST.getReasonPhrase(),
                e.getLocalizedMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ViolationResponse onMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        return new ViolationResponse(LocalDateTime.now(), String.valueOf(HttpStatus.BAD_REQUEST.value()), HttpStatus.BAD_REQUEST.getReasonPhrase(),
                e.getLocalizedMessage());
    }

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ViolationResponse onNotFoundException(EntityNotFoundException e) {
        return new ViolationResponse(LocalDateTime.now(), String.valueOf(HttpStatus.NOT_FOUND.value()),
                HttpStatus.NOT_FOUND.getReasonPhrase(), e.getLocalizedMessage());
    }

    @ExceptionHandler(EntityUniquenessConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ViolationResponse onUniquenessConstraintViolationException(EntityUniquenessConstraintViolationException e) {
        if(e.getMessage().contains("violates not-null constraint")) {
            return new ViolationResponse(LocalDateTime.now(), String.valueOf(HttpStatus.BAD_REQUEST.value()),
                    HttpStatus.BAD_REQUEST.getReasonPhrase(), "Не заполненны обязательные поля");
        }
        return new ViolationResponse(LocalDateTime.now(), String.valueOf(HttpStatus.BAD_REQUEST.value()),
                HttpStatus.BAD_REQUEST.getReasonPhrase(), e.getLocalizedMessage());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ViolationResponse onNotReadableException(HttpMessageNotReadableException e) {
        if (e.getMessage().contains("Required request body is missing")) {
            return new ViolationResponse(LocalDateTime.now(), String.valueOf(HttpStatus.BAD_REQUEST.value()),
                    HttpStatus.BAD_REQUEST.getReasonPhrase(), "Отсутствует требуемый текст запроса");
        }
        return new ViolationResponse(LocalDateTime.now(), String.valueOf(HttpStatus.BAD_REQUEST.value()),
                HttpStatus.BAD_REQUEST.getReasonPhrase(), e.getLocalizedMessage());
    }
}
