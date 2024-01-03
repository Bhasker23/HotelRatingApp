package com.hotelservice.service;

import com.hotelservice.entity.Hotel;

import java.util.List;

public interface HotelServiceIntr {

    Hotel addhotel(Hotel hotel);

    Hotel getHotel(String id);

    List<Hotel> getAllHotel();
}
