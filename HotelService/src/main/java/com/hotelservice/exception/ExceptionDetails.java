package com.hotelservice.exception;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ExceptionDetails {

    private String message;
    private String desc;
    private LocalDateTime dateTime;
}
