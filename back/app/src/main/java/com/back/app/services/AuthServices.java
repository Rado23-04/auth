package com.back.app.services;

import com.back.app.Models.User;
import com.back.app.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class AuthServices {
    @Autowired
    private UserRepository userRepository;

    public String Authenticate (String email,String password){
        Optional<User> optionalUser = userRepository.findByEmail(email);

        if(optionalUser.isPresent()){
            User user = optionalUser.get();
            if(user.getPassword().equals(password)){
                return "Hello"+user.getEmail();
            }
        }
        return "Authenticate failed";
    }
}
