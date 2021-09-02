package com.example.demo.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.sql.Clob;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "blogposts")
public class BlogPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "blogpost_id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "imageurl")
    private String imageUrl;

    @Column(name = "ingredients")
    private String ingredients;

    @Column(name = "instructions")
    private String instructions;

    @Column(name = "content")
    private Clob content;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
//    @JsonIgnore
    private User user;

    @ManyToMany
    @JoinTable(name = "blogpost_tag",
        joinColumns = @JoinColumn(name = "blog_id", referencedColumnName = "blogpost_id"),
        inverseJoinColumns = @JoinColumn(name = "tag_id", referencedColumnName = "id"))
    @JsonIgnoreProperties("blogposts")
    private List<Tag> tags;


}
