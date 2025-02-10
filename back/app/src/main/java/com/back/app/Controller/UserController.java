package com.back.app.Controller;

import com.back.app.Models.User;
import com.back.app.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("api/user")
@RestController
public class UserController {
    @Autowired
    private UserServices userServices;
    @GetMapping("/allUsers")
    public List<User> getAllUsers(){
        return userServices.getListUser();
    }
    @GetMapping("/ping")
    public String ping(){
        return "pong";
    }
}
