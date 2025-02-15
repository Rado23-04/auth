package com.backend.appSpring.ServicesTest;

import com.backend.appSpring.Models.User;
import com.backend.appSpring.Repository.UserRepository;
import com.backend.appSpring.Services.UserServices;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TestServiceUser {
    @InjectMocks
    private UserServices userServices;

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Test
    void TestUserService (){
        User user = new User();
        user.setEmail("test@gmail.com");
        user.setPassword("password123");

        when(passwordEncoder.encode("password123")).thenReturn("hashedPassword");
        when(userRepository.save(any(User.class))).thenAnswer(invocation -> invocation.getArgument(0));

        User savedUser = userServices.saveUser(user);

        assertNotNull(savedUser);
        assertEquals("hashedPassword",savedUser.getPassword());
        verify(userRepository,times(1)).save(any(User.class));
    }

}
