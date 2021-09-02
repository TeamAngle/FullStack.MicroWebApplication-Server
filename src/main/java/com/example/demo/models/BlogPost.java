package com.example.demo.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.sql.Clob;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class BlogPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String imageUrl;
    private Clob content;
    @OneToOne(cascade = CascadeType.ALL)
    private Recipe recipe;
    @ManyToOne
    @JsonIgnore
    private User user;
    @ManyToMany
    @JsonIgnore
    private List<Tag> tags;


}
