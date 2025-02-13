package com.backend.appSpring.Services;

import com.backend.appSpring.Models.User;
import com.backend.appSpring.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public boolean Authenticate (String email, String password){
        Optional<User> optionalUser = userRepository.findByEmail(email);

        if(optionalUser.isPresent()){
            User user = optionalUser.get();
            if(passwordEncoder.matches(password, user.getPassword())){
                return true;
            }
        }
        return false;
    }
}
