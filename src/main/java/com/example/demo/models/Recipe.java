package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String ingredients;
    private String instructions;
    @OneToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    private BlogPost blogPost;


    public Recipe() {
    }

    public Recipe(Long id, String name, String ingredients, String instructions, BlogPost blogPost) {
        this.id = id;
        this.name = name;
        this.ingredients = ingredients;
        this.instructions = instructions;
        this.blogPost = blogPost;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public BlogPost getBlogPost() { return blogPost; }

    public void setBlogPost(BlogPost blogPost) { this.blogPost = blogPost; }

}
