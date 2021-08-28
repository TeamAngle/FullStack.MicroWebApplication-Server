package com.example.demo.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {
    @OneToMany
    private List<BlogPost> blogPostList;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String password;
    Integer postCount;



    public User() {
    }

    public User(Long id, String name, String password, Integer postCount, List<BlogPost> blogPostList) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.postCount = postCount;
        this.blogPostList = blogPostList;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getPostCount() {
        return postCount;
    }

    public void setPostCount(Integer postCount) {
        this.postCount = postCount;
    }

    public List<BlogPost> getBlogPostList() { return blogPostList; }

    public void setBlogPostList(List<BlogPost> blogPostList) { this.blogPostList = blogPostList; }
}
