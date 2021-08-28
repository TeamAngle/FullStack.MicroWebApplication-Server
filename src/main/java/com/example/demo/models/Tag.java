package com.example.demo.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    @ManyToMany(cascade = CascadeType.ALL)
    List<BlogPost> blogPosts;

    public Tag() {
    }

    public Tag(Long id, String name, List<BlogPost> blogPosts) {
        this.id = id;
        this.name = name;
        this.blogPosts = blogPosts;
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

    public List<BlogPost> getBlogPosts() { return blogPosts; }

    public void setBlogPosts(List<BlogPost> blogPosts) { this.blogPosts = blogPosts; }
}



