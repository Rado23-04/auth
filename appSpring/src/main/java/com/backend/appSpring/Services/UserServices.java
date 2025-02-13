package com.backend.appSpring.Services;

import com.backend.appSpring.Config.SecurityConfig;
import com.backend.appSpring.Models.User;
import com.backend.appSpring.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServices {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user){
        String passWordHashage = passwordEncoder.encode(user.getPassword());
        user.setPassword(passWordHashage);
        return userRepository.save(user);
    }
}
