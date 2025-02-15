package com.backend.appSpring.ServicesTest.TestIntegrationServices;

import com.backend.appSpring.Models.User;
import com.backend.appSpring.Repository.UserRepository;
import com.backend.appSpring.Services.UserServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
public class TestIntegrationUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserServices userServices;

    @Test
    void test_integration_user(){
        User user = new User();
        user.setEmail("integration@gmail.com");
        user.setPassword("password");

        User userSaved = userRepository.save(user);
        assertEquals("integration@gmail.com",userSaved.getEmail());
    }
}
