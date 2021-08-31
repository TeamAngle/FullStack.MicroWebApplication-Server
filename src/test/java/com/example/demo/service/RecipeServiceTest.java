package com.example.demo.service;

import com.example.demo.models.Recipe;
import com.example.demo.repository.RecipeRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class RecipeServiceTest {

    @InjectMocks
    RecipeService recipeService;

    @Mock
    RecipeRepository repository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void create() {
        //given
        Recipe recipe = new Recipe();
        Recipe expected = new Recipe();

        //when
        Mockito.when(repository.save(recipe)).thenReturn(expected);
        Recipe Actual = recipeService.create(recipe);

        //Then
        assertEquals(expected,Actual);
    }

    @Test
    void readTest() {
        //given
        List<Long> id = new ArrayList<>();
        Recipe expected = new Recipe();

        //when
        Mockito.when(repository.findById(Mockito.anyLong())).thenReturn(java.util.Optional.of(expected));
        Recipe Actual = recipeService.read(Mockito.anyLong());

        //Then
        assertEquals(expected,Actual);
    }

    @Test
    void readAll() {
        //given
        List<Recipe> list = new ArrayList<>();
        list.add(new Recipe());
        List expected = new ArrayList();

        //when
        Mockito.when(repository.findAll()).thenReturn(expected);
        List actual = recipeService.readAll();

        //Then
        assertEquals(expected,actual);
    }

    @Test
    void update() {
        //given
        Recipe recipe = new Recipe();
        recipe.setName("Airfryer");
        recipe.setIngredients("Spices");
        recipe.setInstructions("Follow me");
        List<Long> id = new ArrayList<>();
        id.add(5L);
        id.add(6L);

        //when
        Mockito.when(repository.findById(Mockito.anyLong())).thenReturn(Optional.of(recipe));
        Mockito.when(repository.save(recipe)).thenReturn(recipe);
        Recipe actual = recipeService.update(Mockito.anyLong(),recipe);

        //Then
        assertEquals(recipe,actual);
    }

    @Test
    void delete() {
        //given
        Recipe recipe = new Recipe();

        //when
        Mockito.when(repository.findById(2L)).thenReturn(Optional.of(recipe));
        Recipe actual = recipeService.delete(recipe);

        //Then
        assertEquals(recipe,actual);
    }

    @Test
    void testDelete() {
        //given
        Recipe recipe = new Recipe();

        //when
        Mockito.when(repository.findById(4L)).thenReturn(Optional.of(recipe));
        Recipe actual = recipeService.delete(4L);

        //Then
        assertEquals(recipe,actual);
    }
}