package com.hotelservice.exception;

public class HotelNotFoundException extends RuntimeException{

    public HotelNotFoundException(){}

    public HotelNotFoundException(String s) {
        super(s);
    }
}
