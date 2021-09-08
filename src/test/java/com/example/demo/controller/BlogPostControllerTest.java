package com.example.demo.controller;

import com.example.demo.models.BlogPost;
import com.example.demo.service.BlogPostService;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class BlogPostControllerTest {
    @Autowired
    MockMvc mockMvc;

    @InjectMocks
    BlogPostController blogPostController;

    @Mock
    BlogPostService service;

    private Gson gson;

    BlogPostControllerTest() {
    }


    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(blogPostController).build();
        gson = new Gson();

    }

    @Test
    void read() throws Exception {

        BlogPost blogPost = new BlogPost();

        Mockito.doReturn(blogPost).when(service).read(Mockito.anyLong());

        mockMvc.perform(get("/blogPostController/read/{id}",5L)).andExpect(status().isOk());
    }

    @Test
    void readAll() throws Exception {

        List<BlogPost> blogPostList = new ArrayList<>();

        Mockito.doReturn(blogPostList).when(service).readAll();

        mockMvc.perform(get("/blogPostController/read",5L)).andExpect(status().isOk());

    }

    @Test
    void create() throws Exception {

        BlogPost blogPost = new BlogPost();

        Mockito.doReturn(blogPost).when(service).create(blogPost);

        mockMvc.perform(post("/blogPostController/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(gson.toJson(blogPost)))
                .andExpect(status().isCreated());
    }

    @Test
    void updateTest() throws Exception {

        BlogPost blogPost = new BlogPost();

        Mockito.when(service.update(5L, blogPost)).thenReturn(blogPost);


        mockMvc.perform(put("/blogPostController/update/{id}",5L)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(gson.toJson(blogPost)))
                .andExpect(status().isOk());
    }

    @Test
    void deleteTest() throws Exception {

        BlogPost blogPost = new BlogPost();
//
        Mockito.doReturn(blogPost).when(service).delete(Mockito.anyLong());

        mockMvc.perform(delete("/blogPostController/delete/{id}", 5L))
                .andExpect(status().isOk());

    }
}