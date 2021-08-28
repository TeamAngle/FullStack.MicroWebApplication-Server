package com.example.demo.controller;

import com.example.demo.service.BlogPostService;
import com.example.demo.models.BlogPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blogPostController")
public class BlogPostController {

    @Autowired
    private BlogPostService service;

    @GetMapping(value = "/read/{id}")
    public ResponseEntity<BlogPost> read(@PathVariable Long id){
        return new ResponseEntity<>(service.read(id), HttpStatus.OK);
    }

    @GetMapping(value = "/read")
    public ResponseEntity<List<BlogPost>> readAll(){
        return new ResponseEntity<>(service.readAll(), HttpStatus.OK);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<BlogPost> create(@RequestBody BlogPost blogPost){
        return new ResponseEntity<>(service.create(blogPost), HttpStatus.CREATED);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<BlogPost> update(@PathVariable Long id, @RequestBody BlogPost blogPost){
        return new ResponseEntity<>(service.update(id, blogPost), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<BlogPost> delete(@PathVariable Long id){
        return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
    }
}
