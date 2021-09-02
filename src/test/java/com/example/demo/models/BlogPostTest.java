package com.example.demo.models;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;


class BlogPostTest {

    @InjectMocks
    BlogPost blogPost;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getId() {
        //given
        Long expectedId = 5L;
        blogPost.setId(5L);

        //when
        Long Actual = blogPost.getId();

        //Then
       Assert.assertEquals(expectedId,Actual);

    }
    @Test
    void getTitle() {
        //given
        String expectedTitle = "Blogs";
        blogPost.setTitle("Blogs");

        //when
        String Actual = blogPost.getTitle();

        //Then
        Assert.assertEquals(expectedTitle,Actual);
    }
    @Test
    void getImageUrl() {
        //given
        String expectedImageUrl = "abc012@xyz.com";
        blogPost.setImageUrl("abc012@xyz.com");

        //when
        String Actual = blogPost.getImageUrl();

        //Then
        Assert.assertEquals(expectedImageUrl,Actual);
    }

//    @Test
//    void getRecipe() {
//        //given
//        Recipe expectedRecipe = new Recipe();
//        blogPost.setRecipe(expectedRecipe);
//
//        //when
//        Recipe Actual = blogPost.getRecipe();
//
//        //Then
//        Assert.assertEquals(expectedRecipe,Actual);
//
//    }

    @Test
    void getUser() {
        //given
        User expectedUser = new User();
        blogPost.setUser(expectedUser);

        //when
        User Actual = blogPost.getUser();

        //Then
        Assert.assertEquals(expectedUser,Actual);
    }

    @Test
    void getTags() {
        //given
        List expectedTags = new ArrayList();
        blogPost.setTags(expectedTags);

        //when
        List Actual = blogPost.getTags();

        //Then
        Assert.assertEquals(expectedTags,Actual);

    }

}