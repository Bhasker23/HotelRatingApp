package com.rating.controller;

import com.rating.entity.Rating;
import com.rating.service.RatingServiceIntr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rating")
public class RatingController {

    @Autowired
    private RatingServiceIntr ratingServiceIntr;

    @PostMapping("/add")
    public ResponseEntity<Rating> addRating(@RequestBody Rating rating){
        return new ResponseEntity<Rating>(ratingServiceIntr.addRating(rating), HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Rating>> getAllRatings(){
        return new ResponseEntity<>(ratingServiceIntr.getRatings(),HttpStatus.OK);
    }

    @GetMapping("/getAllRatingByUserID/{userId}")
    public ResponseEntity<List<Rating>> getRatingsByUserId(@PathVariable String userId){
        return new ResponseEntity<>(ratingServiceIntr.getRatingByUserId(userId),HttpStatus.OK);
    }
    @GetMapping("/getAllRatingByHotelId/{hotelId}")
    public ResponseEntity<List<Rating>> getRatingsByHotelId(@PathVariable String hotelId){
        return new ResponseEntity<>(ratingServiceIntr.getRatingByHotelId(hotelId),HttpStatus.OK);
    }
}
