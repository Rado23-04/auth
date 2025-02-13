package com.backend.appSpring.Controller;

import com.backend.appSpring.Models.User;
import com.backend.appSpring.Services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*",allowedHeaders = "*")
@RestController
public class UserController {

    @Autowired
    private UserServices userServices;

    @GetMapping("/ping")
    private String pong(){
        return "pong";
    }

    @PostMapping("/save")
    private User save(@RequestBody User user){
        return userServices.saveUser(user);
    }
}
