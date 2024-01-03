package com.usermicroservice.controller;

import com.usermicroservice.entity.User;
import com.usermicroservice.service.UserServiceIntr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usermicro")
public class UserController {

    @Autowired
    private UserServiceIntr userServiceIntr;

    @PostMapping("/addUser")
    public ResponseEntity<User> addStudent(@RequestBody User user){
        return  new ResponseEntity<User>(userServiceIntr.adduser(user), HttpStatus.CREATED);
    }

    @GetMapping("/getUser/{userid}")
    public ResponseEntity<User> findUser(@PathVariable  String userid){
        return  new ResponseEntity<User>(userServiceIntr.getUser(userid), HttpStatus.OK);
    }

    @GetMapping("/getAllUser")
    public ResponseEntity<List<User>> findAllUser(){
        return  new ResponseEntity<List<User>>(userServiceIntr.getAllUser(), HttpStatus.OK);
    }
}
