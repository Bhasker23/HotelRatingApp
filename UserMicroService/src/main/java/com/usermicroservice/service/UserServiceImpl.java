package com.usermicroservice.service;

import com.usermicroservice.entity.User;
import com.usermicroservice.exception.UserNotFondException;
import com.usermicroservice.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserServiceIntr {

    @Autowired
    private UserRepo userRepo;

    @Override
    public User adduser(User user) {
        String uuid = UUID.randomUUID().toString();
        user.setId(uuid);
        return userRepo.save(user);
    }

    @Override
    public User getUser(String id) {
        return userRepo.findById(id).orElseThrow(() -> new UserNotFondException("User not found with given id : " + id));
    }

    @Override
    public List<User> getAllUser() {
        return userRepo.findAll();
    }
}
