package com.example.demo.config;

import com.example.demo.models.User;
import com.example.demo.repository.BlogPostRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public class UserConfig {
    @Autowired
    private UserRepository repo;

    @Autowired
    private BlogPostService service;

    @PostConstruct
    public void setup(){
        repo.save(new User(0L, "Raymond", "password", 4, service.readAll()));
    }
    }
