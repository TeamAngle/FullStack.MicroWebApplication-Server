package com.example.demo.controller;

import com.example.demo.models.BlogPost;
import com.example.demo.models.Tag;
import com.example.demo.service.TagService;
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
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class TagControllerTest {
    @Autowired
    MockMvc mockMvc;

    @InjectMocks
    TagController tagController;

    @Mock
    TagService service;

    private Gson gson;

    TagControllerTest(){

    }
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(tagController).build();
        gson = new Gson();
    }

    @Test
    void read() throws Exception {

        Tag tag = new Tag();

        Mockito.doReturn(tag).when(service).read(Mockito.anyLong());

        mockMvc.perform(get("/tagController/read/{id}",5L)).andExpect(status().isOk());
    }

    @Test
    void readAll() throws Exception {

        List<Tag> tagList = new ArrayList<>();

        Mockito.doReturn(tagList).when(service).readAll();

        mockMvc.perform(get("/tagController/read",5L)).andExpect(status().isOk());
    }

    @Test
    void create() throws Exception {

        Tag tag = new Tag();

        Mockito.doReturn(tag).when(service).create(tag);

        mockMvc.perform(post("/tagController/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(gson.toJson(tag)))
                .andExpect(status().isCreated());
    }

    @Test
    void update() throws Exception {

        Tag tag = new Tag();

        Mockito.when(service.update(5L, tag)).thenReturn(tag);

        mockMvc.perform(put("/tagController/update/{id}",5L)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(gson.toJson(tag)))
                .andExpect(status().isOk());


    }

    @Test
    void deleteTest() throws Exception {

        Tag tag = new Tag();

        Mockito.doReturn(tag).when(service).delete(Mockito.anyLong());

        mockMvc.perform(delete("/tagController/delete/{id}", 5L))
                .andExpect(status().isOk());
    }
}