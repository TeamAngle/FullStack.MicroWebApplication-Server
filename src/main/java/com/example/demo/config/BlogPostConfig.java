package com.example.demo.config;

import com.example.demo.models.BlogPost;
import com.example.demo.models.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public class BlogPostConfig {
    @Autowired
    private BlogPostService service;

    @Autowired
    private UserRepository repo;

    @PostConstruct
    public void setup(){
        for (int i = 0; i < 4; i++) {
             service.create(new BlogPost());
             repo.save(new User(0L, "Raymond", "password", 4, service.readAll()));
        }
    }
}
