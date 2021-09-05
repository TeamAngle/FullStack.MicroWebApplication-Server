package com.example.demo.models;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class TagTest {

    @InjectMocks
    Tag tag;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getId() {
        //given
        Long expectedId = 6L;
        tag.setId(6L);

        //when
        Long actual = tag.getId();

        //Then
        assertEquals(expectedId,actual);
    }

    @Test
    void getName() {
        //given
        String expectedName = "HashTag";
        tag.setName("HashTag");

        //when
        String actual = tag.getName();

        //Then
       assertEquals(expectedName,actual);
    }

    @Test
    void getBlogPosts() {
        //given
        List expectedPosts = new ArrayList();
        tag.setBlogPosts(expectedPosts);

        //when
        List actual = tag.getBlogPosts();

        //Then
        assertEquals(expectedPosts,actual);


    }
}