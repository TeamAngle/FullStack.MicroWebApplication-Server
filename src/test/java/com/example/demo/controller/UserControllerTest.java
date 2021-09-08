package com.example.demo.controller;

import com.example.demo.models.BlogPost;
import com.example.demo.models.User;
import com.example.demo.service.UserService;
import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class UserControllerTest {

    @Autowired
    MockMvc mockMvc;

    @InjectMocks
    UserController userController;

    @Mock
    UserService service;

    private Gson gson;

    UserControllerTest(){

    }

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
        gson = new Gson();
    }

    @Test
    void read() throws Exception {

        User user = new User();

        Mockito.doReturn(user).when(service).read(Mockito.anyLong());

        mockMvc.perform(get("/userController/read/{id}",5L)).andExpect(status().isOk());
    }

    @Test
    void readAll() throws Exception {

        List<User> userList = new ArrayList<>();

        Mockito.doReturn(userList).when(service).readAll();

        mockMvc.perform(get("/userController/read",5L)).andExpect(status().isOk());
    }

    @Test
    void create() throws Exception {

        User user = new User();

        Mockito.doReturn(user).when(service).create(user);

        mockMvc.perform(post("/userController/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(gson.toJson(user)))
                .andExpect(status().isCreated());
    }

    @Test
    void update() throws Exception {

        User user = new User();

        Mockito.when(service.update(5L, user)).thenReturn(user);

        mockMvc.perform(put("/userController/update/{id}",5L)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(gson.toJson(user)))
                .andExpect(status().isOk());
    }

    @Test
    void deleteTest() throws Exception {

        User user = new User();

        Mockito.doReturn(user).when(service).delete(Mockito.anyLong());

        mockMvc.perform(delete("/userController/delete/{id}", 5L))
                .andExpect(status().isOk());
    }
}