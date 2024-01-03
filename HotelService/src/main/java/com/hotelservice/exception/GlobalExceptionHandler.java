package com.hotelservice.exception;

import com.hotelservice.entity.Hotel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(HotelNotFoundException.class)
    public ResponseEntity<ExceptionDetails> hotelExceptionHandler(HotelNotFoundException hx, WebRequest wr) {

        ExceptionDetails ex = new ExceptionDetails();
        ex.setMessage(hx.getMessage());
        ex.setDesc(wr.getDescription(false));
        ex.setDateTime(LocalDateTime.now());

        return new ResponseEntity<ExceptionDetails>(ex, HttpStatus.NOT_FOUND);








    }



}
