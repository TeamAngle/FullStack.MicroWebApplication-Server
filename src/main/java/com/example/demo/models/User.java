package com.example.demo.models;

import javax.persistence.*;
import java.sql.Blob;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @OneToMany(orphanRemoval = true)
    private List<BlogPost> blogPostList;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "username")
    String name;

    @Column(name = "password")
    String password;

    @Column(name = "email")
    String email;

    @Lob
    @Column(name = "userImage")
    Blob userImage;



    public User() {
    }

    public User(List<BlogPost> blogPostList, Long id, String name, String password, String email, Blob userImage) {
        this.blogPostList = blogPostList;
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.userImage = userImage;
    }

    public List<BlogPost> getBlogPostList() {
        return blogPostList;
    }

    public void setBlogPostList(List<BlogPost> blogPostList) {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Blob getUserImage() {
        return userImage;
    }

    public void setUserImage(Blob userImage) {
        this.userImage = userImage;
    }
}
