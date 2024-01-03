package com.usermicroservice.exception;

public class UserNotFondException extends RuntimeException {

    public UserNotFondException(){}

    public UserNotFondException(String message){
        super(message);
    }
}
