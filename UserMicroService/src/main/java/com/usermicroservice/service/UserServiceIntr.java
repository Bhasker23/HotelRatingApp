package com.usermicroservice.service;

import com.usermicroservice.entity.User;

import java.util.List;

public interface UserServiceIntr {

    User adduser(User user);
    User getUser(String id);
    List<User> getAllUser();


}
