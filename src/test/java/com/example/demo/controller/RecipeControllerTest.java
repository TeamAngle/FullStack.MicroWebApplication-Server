package com.example.demo.controller;

import com.example.demo.models.Recipe;
import com.example.demo.service.RecipeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RecipeControllerTest {
    @InjectMocks
    RecipeController recipeController;

    @Mock
    RecipeService service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void read() {
        //given
        Recipe recipe = new Recipe();
        ResponseEntity<Recipe> expected = new ResponseEntity<>(recipe, HttpStatus.OK);

        //when
        Mockito.doReturn(recipe).when(service).read(Mockito.anyLong());
        ResponseEntity<Recipe> actual = recipeController.read(Mockito.anyLong());

        //Then
        assertEquals(expected,actual);
    }

    @Test
    void readAll() {
        //given
        List<Recipe> recipes = new ArrayList<>();
        ResponseEntity<List<Recipe>> expected = new ResponseEntity<>(recipes,HttpStatus.OK);

        //when
        Mockito.doReturn(recipes).when(service).readAll();
        ResponseEntity<List<Recipe>> actual = recipeController.readAll();

        //Then
        assertEquals(expected,actual);
    }

    @Test
    void create() {
        //given
        Recipe recipe = new Recipe();
        ResponseEntity<Recipe> expected = new ResponseEntity<>(recipe,HttpStatus.CREATED);

        //when
        Mockito.doReturn(recipe).when(service).create(recipe);
        ResponseEntity<Recipe> actual = recipeController.create(recipe);

        //Then
        assertEquals(expected,actual);
    }

    @Test
    void update() {
        //given
        Recipe recipe = new Recipe();
        ResponseEntity<Recipe> expected = new ResponseEntity<>(recipe,HttpStatus.OK);

        //when
        Mockito.when(service.update(5L, recipe)).thenReturn(recipe);

        ResponseEntity<Recipe> actual = recipeController.update(5L,recipe);

        //Then
        assertEquals(expected,actual);
    }

    @Test
    void delete() {
        //given
        Recipe recipe = new Recipe();
        ResponseEntity<Recipe> expected = new ResponseEntity<>(recipe,HttpStatus.OK);

        //when
        Mockito.doReturn(recipe).when(service).delete(Mockito.anyLong());
        ResponseEntity<Recipe> actual = recipeController.delete(Mockito.anyLong());

        //Then
        assertEquals(expected,actual);
    }
}