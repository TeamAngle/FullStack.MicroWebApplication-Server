package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recipeController")
public class RecipeController {

    @Autowired
    private RecipeService service;

    @GetMapping(value = "/read/{id}")
    public ResponseEntity<Recipe> read(@PathVariable Long id){
        return new ResponseEntity<>(service.read(id), HttpStatus.OK);
    }

    @GetMapping(value = "/read")
    public ResponseEntity<List<Recipe>> readAll(){
        return new ResponseEntity<>(service.readAll(), HttpStatus.OK);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Recipe> create(@RequestBody Recipe recipe){
        return new ResponseEntity<>(service.create(recipe), HttpStatus.CREATED);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Recipe> update(@PathVariable Long id, @RequestBody Recipe recipe){
        return new ResponseEntity<>(service.update(id, recipe), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Recipe> delete(@PathVariable Long id){
        return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
    }
}
