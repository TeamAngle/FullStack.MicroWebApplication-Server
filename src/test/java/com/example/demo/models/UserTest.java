package com.example.demo.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @InjectMocks
    User user;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getId() {
        //given
        Long expectedId = 7L;
        user.setId(7L);

        //when
        Long Actual = user.getId();

        //Then
        assertEquals(expectedId,Actual);
    }

    @Test
    void getName() {
        //given
        String expectedName = "Nisha";
        user.setName("Nisha");

        //when
        String actual = user.getName();

        //Then
        assertEquals(expectedName,actual);
    }

    @Test
    void getPassword() {
        //given
        String expectedPassword = "zipcode";
        user.setPassword("zipcode");

        //when
        String actual = user.getPassword();

        //Then
       assertEquals(expectedPassword,actual);
    }

    @Test
    void getBlogPostList() {
        //given
        List expectedBlogPostList = new ArrayList();
        user.setBlogPostList(expectedBlogPostList);

        //when
        List actual = user.getBlogPostList();

        //Then
        assertEquals(expectedBlogPostList,actual);
    }
}