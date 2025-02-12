package com.backend.appSpring.Services;

import com.backend.appSpring.Models.User;
import com.backend.appSpring.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;

    public boolean Authenticate (String email, String password){
        Optional<User> optionalUser = userRepository.findByEmail(email);

        if(optionalUser.isPresent()){
            User user = optionalUser.get();
            if(user.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }
}
