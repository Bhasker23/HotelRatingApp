package com.hotelservice.service;

import com.hotelservice.entity.Hotel;
import com.hotelservice.exception.HotelNotFoundException;
import com.hotelservice.repo.HotelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelServiceIntr {

    @Autowired
    private HotelRepo hotelRepo;

    @Override
    public Hotel addhotel(Hotel hotel) {

        String uuid = UUID.randomUUID().toString();
        hotel.setId(uuid);
        return hotelRepo.save(hotel);
    }

    @Override
    public Hotel getHotel(String id) {


        return hotelRepo.findById(id).orElseThrow(() -> new HotelNotFoundException("Hotel not found with the given id : " + id));
    }

    @Override
    public List<Hotel> getAllHotel() {
        return hotelRepo.findAll();
    }
}
