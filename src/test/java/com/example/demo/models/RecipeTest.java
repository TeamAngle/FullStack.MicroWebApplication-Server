//package com.example.demo.models;
//
//import org.junit.Assert;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.MockitoAnnotations;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class RecipeTest {
//
//    @InjectMocks
//    Recipe recipe;
//
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.initMocks(this);
//    }
//
//    @Test
//    void getId() {
//        //given
//        Long expectedId = 4L;
//       recipe.setId(4L);
//
//        //When
//        Long Actual = recipe.getId();
//
//        //Then
//        Assert.assertEquals(expectedId,Actual);
//    }
//
//    @Test
//    void getName() {
//        //given
//        String expectedName = "Airfryer";
//        recipe.setName("Airfryer");
//
//        //when
//        String Actual = recipe.getName();
//
//        //Then
//        Assert.assertEquals(expectedName,Actual);
//    }
//
//    @Test
//    void getIngredients() {
//        //given
//        String expectedIngredients = "Spices";
//        recipe.setIngredients("Spices");
//
//        //When
//        String Actual = recipe.getIngredients();
//
//        //Then
//        Assert.assertEquals(expectedIngredients,Actual);
//    }
//
//    @Test
//    void getInstructions() {
//        //given
//        String expectedInstruction = "FollowMe";
//        recipe.setInstructions("FollowMe");
//
//        //when
//        String Actual = recipe.getInstructions();
//
//        //Then
//        Assert.assertEquals(expectedInstruction,Actual);
//    }
//
//    @Test
//    void getBlogPost() {
//        //given
//        BlogPost expectedBlogPost = new BlogPost();
//        recipe.setBlogPost(expectedBlogPost);
//
//        //when
//        BlogPost Actual = recipe.getBlogPost();
//
//        //Then
//        Assert.assertEquals(expectedBlogPost,Actual);
//
//    }
//
//}