package com.hotelservice.controller;

import com.hotelservice.entity.Hotel;
import com.hotelservice.service.HotelServiceIntr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    private HotelServiceIntr hotelServiceIntr;

    @PostMapping("/add")
    public ResponseEntity<Hotel> addHotel(@RequestBody Hotel hotel){
        return  new ResponseEntity<Hotel>(hotelServiceIntr.addhotel(hotel), HttpStatus.CREATED);
    }

    @GetMapping("/getHotel/{hotelId}")
    public ResponseEntity<Hotel> findHotel(@PathVariable  String hotelId){
        return  new ResponseEntity<Hotel>(hotelServiceIntr.getHotel(hotelId), HttpStatus.OK);
    }

    @GetMapping("/getAllHotel")
    public ResponseEntity<List<Hotel>> findAllHotel(){
        return  new ResponseEntity<List<Hotel>>(hotelServiceIntr.getAllHotel(), HttpStatus.OK);
    }
}
