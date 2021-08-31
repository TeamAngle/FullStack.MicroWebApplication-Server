package com.example.demo.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


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
        Long actual = blogPost.getId();

        //Then
        assertEquals(expectedId,actual);

    }
    @Test
    void getTitle() {
        //given
        String expectedTitle = "Blogs";
        blogPost.setTitle("Blogs");

        //when
        String actual = blogPost.getTitle();

        //Then
        assertEquals(expectedTitle,actual);
    }
    @Test
    void getImageUrl() {
        //given
        String expectedImageUrl = "abc012@xyz.com";
        blogPost.setImageUrl("abc012@xyz.com");

        //when
        String actual = blogPost.getImageUrl();

        //Then
        assertEquals(expectedImageUrl,actual);
    }

    @Test
    void getRecipe() {
        //given
        Recipe expectedRecipe = new Recipe();
        blogPost.setRecipe(expectedRecipe);

        //when
        Recipe actual = blogPost.getRecipe();

        //Then
       assertEquals(expectedRecipe,actual);

    }

    @Test
    void getUser() {
        //given
        User expectedUser = new User();
        blogPost.setUser(expectedUser);

        //when
        User actual = blogPost.getUser();

        //Then
        assertEquals(expectedUser,actual);
    }

    @Test
    void getTags() {
        //given
        List expectedTags = new ArrayList();
        blogPost.setTags(expectedTags);

        //when
        List actual = blogPost.getTags();

        //Then
        assertEquals(expectedTags,actual);

    }

}