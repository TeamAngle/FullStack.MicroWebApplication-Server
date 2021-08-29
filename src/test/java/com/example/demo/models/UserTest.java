package com.example.demo.models;

import org.junit.Assert;
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
        Assert.assertEquals(expectedId,Actual);
    }

    @Test
    void getName() {
        //given
        String expectedName = "Nisha";
        user.setName("Nisha");

        //when
        String Actual = user.getName();

        //Then
        Assert.assertEquals(expectedName,Actual);
    }

    @Test
    void getPassword() {
        //given
        String expectedPassword = "zipcode";
        user.setPassword("zipcode");

        //when
        String Actual = user.getPassword();

        //Then
        Assert.assertEquals(expectedPassword,Actual);
    }

    @Test
    void getPostCount() {
        //given
        Integer expectedPostCount = 10;
        user.setPostCount(10);

        //when
        Integer Actual = user.getPostCount();

        //Then
        Assert.assertEquals(expectedPostCount,Actual);

    }

    @Test
    void getBlogPostList() {
        //given
        List expectedBlogPostList = new ArrayList();
        user.setBlogPostList(expectedBlogPostList);

        //when
        List Actual = user.getBlogPostList();

        //Then
        Assert.assertEquals(expectedBlogPostList,Actual);
    }
}