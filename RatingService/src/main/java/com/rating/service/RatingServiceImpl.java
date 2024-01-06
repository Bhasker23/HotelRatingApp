package com.rating.service;

import com.rating.entity.Rating;
import com.rating.repo.RatingRepo;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RatingServiceImpl implements RatingServiceIntr{

    @Autowired
    private RatingRepo ratingRepo;

    @Override
    public Rating addRating(Rating rating) {

        String uuid = UUID.randomUUID().toString();
        rating.setRatingId(uuid);
        return ratingRepo.save(rating);
    }

    @Override
    public List<Rating> getRatings() {
        return ratingRepo.findAll();
    }

    @Override
    public List<Rating> getRatingByUserId(String userId) {
        return ratingRepo.findByUserId(userId);
    }

    @Override
    public List<Rating> getRatingByHotelId(String hotelId) {
        return ratingRepo.findByHotelId(hotelId);
    }
}
