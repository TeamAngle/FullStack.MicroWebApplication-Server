package com.example.demo.models;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class BlogPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String imageUrl;
    @OneToOne(cascade = CascadeType.ALL)
    private Recipe recipe;
    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    private User user;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Tag> tags;

    public BlogPost() {
    }

    public BlogPost(Long id, String title, String imageUrl, Recipe recipe, User user, List<Tag> tags) {
        this.id = id;
        this.title = title;
        this.imageUrl = imageUrl;
        this.recipe = recipe;
        this.user = user;
        this.tags = tags;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Recipe getRecipe() { return recipe; }

    public void setRecipe(Recipe recipe) { this.recipe = recipe; }

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }
}
