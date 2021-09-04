package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tags")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "name")
    String name;
    @ManyToMany
    @JoinTable(
            joinColumns = @JoinColumn (name = "tag_id"),
            inverseJoinColumns = @JoinColumn (name = "blog_posts_id")
    )
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



