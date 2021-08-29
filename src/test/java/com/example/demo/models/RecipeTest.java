package com.example.demo.models;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RecipeTest {

    @InjectMocks
    Recipe recipe;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getId() {
        //given
        Long expectedId = 4L;
       recipe.setId(4L);

        //When
        Long Actual = recipe.getId();

        //Then
        assertEquals(expectedId,Actual);
    }

    @Test
    void getName() {
        //given
        String expectedName = "Airfryer";
        recipe.setName("Airfryer");

        //when
        String Actual = recipe.getName();

        //Then
       assertEquals(expectedName,Actual);
    }

    @Test
    void getIngredients() {
        //given
        String expectedIngredients = "Spices";
        recipe.setIngredients("Spices");

        //When
        String Actual = recipe.getIngredients();

        //Then
        assertEquals(expectedIngredients,Actual);
    }

    @Test
    void getInstructions() {
        //given
        String expectedInstruction = "FollowMe";
        recipe.setInstructions("FollowMe");

        //when
        String Actual = recipe.getInstructions();

        //Then
       assertEquals(expectedInstruction,Actual);
    }

    @Test
    void getBlogPost() {
        //given
        BlogPost expectedBlogPost = new BlogPost();
        recipe.setBlogPost(expectedBlogPost);

        //when
        BlogPost Actual = recipe.getBlogPost();

        //Then
        assertEquals(expectedBlogPost,Actual);

    }

}