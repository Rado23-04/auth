package com.backend.appSpring.ServicesTest;

import com.backend.appSpring.Models.User;
import com.backend.appSpring.Repository.UserRepository;
import com.backend.appSpring.Services.AuthService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)

public class TestServiceAuthentication {

    @InjectMocks
    private AuthService authService;

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Test
    void authentication_should_return_true(){
        User user = new User();
        user.setEmail("true@gmail.com");
        user.setPassword("hashedPassword");

        when(userRepository.findByEmail("true@gmail.com")).thenReturn(Optional.of(user));
        when(passwordEncoder.matches("password123","hashedPassword")).thenReturn(true);

        boolean result = authService.Authenticate("true@gmail.com","password123");

        assertTrue(result);
    }

    @Test
    void authentication_should_return_false_when_user_not_found(){
        when(userRepository.findByEmail("unknow@gmail.com")).thenReturn(Optional.empty());

        boolean result = authService.Authenticate("unknow@gmail.com","password123");

        assertFalse(result);
    }

    @Test
    void uthentication_should_return_false_when_password_wrong(){
        User user = new User();
        user.setEmail("wrong@gmail.com");
        user.setPassword("password");

        when(userRepository.findByEmail("wrong@gmail.com")).thenReturn(Optional.of(user));
        when(passwordEncoder.matches("wrong","password")).thenReturn(false);

        boolean result = authService.Authenticate("wrong@gmail.com","wrong");

        assertFalse(result);
    }
}
