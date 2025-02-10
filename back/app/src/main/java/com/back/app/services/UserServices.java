package com.back.app.services;

import com.back.app.Models.User;
import com.back.app.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServices {
    @Autowired
    private UserRepository userRepository;

    public List<User> getListUser(){
        return userRepository.findAll();
    }
}
