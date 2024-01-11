package com.usermicroservice.controller;

import com.usermicroservice.entity.User;
import com.usermicroservice.service.UserServiceIntr;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usermicro")
@Builder
public class UserController {

    @Autowired
    private UserServiceIntr userServiceIntr;

    private static Integer retryInstance = 1;
    @PostMapping("/addUser")
    public ResponseEntity<User> addStudent(@RequestBody User user) {
        return new ResponseEntity<User>(userServiceIntr.adduser(user), HttpStatus.CREATED);
    }


    @GetMapping("/getUser/{userid}")
//    @CircuitBreaker(name = "ratingHotelBreaker", fallbackMethod = "ratingHotelFallbackMethod")
    @Retry(name = "ratingHotelBreaker" , fallbackMethod = "ratingHotelFallbackMethod")
    public ResponseEntity<User> findUser(@PathVariable String userid) {

        System.out.println("call Retry : " + retryInstance);
        retryInstance++;
        return new ResponseEntity<User>(userServiceIntr.getUser(userid), HttpStatus.OK);
    }

//    Fall back method
    public ResponseEntity<User> ratingHotelFallbackMethod(@PathVariable String userId, Exception ex) {

        User user = User.builder().id("dummyId").email("dummy@mailId").name("Dummy").build();

        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    @GetMapping("/getAllUser")
    public ResponseEntity<List<User>> findAllUser() {
        return new ResponseEntity<List<User>>(userServiceIntr.getAllUser(), HttpStatus.OK);
    }
}
