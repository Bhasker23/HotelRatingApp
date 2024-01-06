package com.rating.service;

import com.rating.entity.Rating;

import java.util.List;

public interface RatingServiceIntr {

    Rating addRating(Rating rating);

    List<Rating> getRatings();

    List<Rating> getRatingByUserId(String userId);

    List<Rating> getRatingByHotelId(String hotelId);


}
