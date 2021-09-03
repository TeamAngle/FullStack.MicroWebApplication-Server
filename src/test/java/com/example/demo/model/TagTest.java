package com.example.demo.model;

import com.example.demo.model.entity.Tag;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

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
        Long Actual = tag.getId();

        //Then
        Assert.assertEquals(expectedId,Actual);
    }

    @Test
    void getName() {
        //given
        String expectedName = "HashTag";
        tag.setName("HashTag");

        //when
        String Actual = tag.getName();

        //Then
        Assert.assertEquals(expectedName,Actual);
    }

    @Test
    void getBlogPosts() {
        //given
        List expectedPosts = new ArrayList();
        tag.setBlogPosts(expectedPosts);

        //when
        List Actual = tag.getBlogPosts();

        //Then
        Assert.assertEquals(expectedPosts,Actual);


    }
}