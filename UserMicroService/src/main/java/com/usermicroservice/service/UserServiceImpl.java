package com.usermicroservice.service;

import com.usermicroservice.entity.Hotel;
import com.usermicroservice.entity.Rating;
import com.usermicroservice.entity.User;
import com.usermicroservice.exception.UserNotFondException;
import com.usermicroservice.external.service.HotelFiegnService;
import com.usermicroservice.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserServiceIntr {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HotelFiegnService hotelFiegnService;

    @Override
    public User adduser(User user) {
        String uuid = UUID.randomUUID().toString();
        user.setId(uuid);
        return userRepo.save(user);
    }

    @Override
    public User getUser(String id) {
        User user = userRepo.findById(id).orElseThrow(() -> new UserNotFondException("User not found with given id : " + id));

        Rating[] ratingsByUser = restTemplate.getForObject("http://RATING-SERVICE/rating/getAllRatingByUserID/"+id, Rating[].class);

        List<Rating> ratings = Arrays.stream(ratingsByUser).toList();

        List<Rating> updatedratingList = ratings.stream().map(rating -> {
//            ResponseEntity<Hotel> response = restTemplate.getForEntity("http://HOTEL-SERVICE/hotel/getHotel/"+rating.getHotelId(),Hotel.class);
//            rating.setHotel(response.getBody());

            Hotel hotel = hotelFiegnService.getHotel(rating.getHotelId());
            rating.setHotel(hotel);
            return rating;
        }).toList();

        user.setRatings(updatedratingList);
        return user;
    }

    @Override
    public List<User> getAllUser() {
        return userRepo.findAll();
    }
}
