package com.RCTR.usersys;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.Matchers.*;
import org.aspectj.lang.annotation.Before;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.RCTR.usersys.controller.UserController;
import com.RCTR.usersys.entity.UserEntity;
import com.RCTR.usersys.model.User;
import com.RCTR.usersys.repository.UserRepository;
import com.RCTR.usersys.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {
    private MockMvc mockMvc;
    ObjectMapper objectMapper = new ObjectMapper();
    ObjectWriter objectwriter = objectMapper.writer();
    @Mock
    private UserService userService;
    @InjectMocks
    private UserController userController;
    
    User USER_1 = new User(1L ,"Laur","Pinzaru","laur@pinz.com" );
    User USER_2 = new User(2L ,"Petru","Gologan","petru@gologan.com" );
    User USER_3 = new User(3L ,"Luca","Pinzaru","luca@pinz.com" );

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @Test
    public void getAllUsersSuccess() throws Exception{
        List<User> users = new ArrayList<>(Arrays.asList(USER_1,USER_2,USER_3));
        Mockito.when(userService.getAllUsers()).thenReturn(users);
        System.out.println("Mocked users: " + userService.getAllUsers());

        mockMvc.perform(MockMvcRequestBuilders
                .get("/api/v1/users")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
               
                 .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(3)))
                 .andExpect(jsonPath("$[2].firstName", is("Luca")));
                // .andExpect(jsonPath("$[1].lastName", is(Gologan)));
                
        
        
    }
    
}   
