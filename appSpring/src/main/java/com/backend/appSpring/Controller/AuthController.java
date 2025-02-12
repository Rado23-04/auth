package com.backend.appSpring.Controller;

import com.backend.appSpring.Models.User;
import com.backend.appSpring.Services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class AuthController {
    @Autowired
    private AuthService authService;
    @PostMapping("/auth")
    public ResponseEntity<?> check(@RequestBody User user){
        boolean isAuthentified = authService.Authenticate(user.getEmail(),user.getPassword());
        if(isAuthentified){
            return ResponseEntity.ok().body(Map.of("success",true,"message","Authentification succes"));
        }
        return ResponseEntity.ok().body(Map.of("failed",true,"message","Authentification failed"));

    }
}
