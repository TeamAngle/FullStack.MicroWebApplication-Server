package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {

}
