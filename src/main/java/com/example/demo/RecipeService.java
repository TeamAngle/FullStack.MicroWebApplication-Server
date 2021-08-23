package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecipeService {
    @Autowired
    private RecipeRepository repository;

    public Recipe create(Recipe recipe){
        return repository.save(recipe);
    }

    public Recipe read(Long id){
        return repository.findById(id).get();
    }

    public List<Recipe> readAll(){
        Iterable<Recipe> recipeIterable = repository.findAll();
        List<Recipe> result = new ArrayList<>();
        recipeIterable.forEach(result::add);
        return result;
    }

    public Recipe update(Long id, Recipe newRecipe){
        Recipe recipeInDatabase = read(id);
        recipeInDatabase.setName(newRecipe.getName());
        recipeInDatabase.setIngredients(newRecipe.getIngredients());
        recipeInDatabase.setInstructions(newRecipe.getInstructions());
        return repository.save(recipeInDatabase);
    }

    public Recipe delete(Recipe recipe){
        repository.delete(recipe);
        return recipe;
    }

    public Recipe delete(Long id){
        return delete(read(id));
    }
}
