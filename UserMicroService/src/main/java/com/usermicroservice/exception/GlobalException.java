package com.usermicroservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDate;
import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalException {

    @ExceptionHandler(UserNotFondException.class)
    public ResponseEntity<ExceptionDetails> UserExceptionHandler(UserNotFondException ex, WebRequest wr){

        ExceptionDetails e = new ExceptionDetails();
        e.setMessage(ex.getMessage());
        e.setDesc(wr.getDescription(false));
        e.setDate(LocalDateTime.now());

        return new ResponseEntity<ExceptionDetails>(e, HttpStatus.NOT_FOUND);
    }
}
