package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class BlogPostService {
    @Autowired
    BlogPostRepository repository;

    public BlogPost create(BlogPost blogPost){return repository.save(blogPost);}

    public BlogPost read(Long id){ return repository.findById(id).get();}

    public List<BlogPost> readAll(){
        Iterable<BlogPost> blogPostsIterable = repository.findAll();
        List<BlogPost> result = new ArrayList<>();
        blogPostsIterable.forEach(result::add);
        return result;
    }

    public BlogPost update(Long id, BlogPost newBlogPost){
        BlogPost blogPostInDatabase = read(id);
        blogPostInDatabase.setImageUrl(newBlogPost.getImageUrl());
        blogPostInDatabase.setTitle(newBlogPost.getTitle());
        return repository.save(blogPostInDatabase);
    }

    public BlogPost delete(BlogPost blogPost){
        repository.delete(blogPost);
        return blogPost;
    }

    public BlogPost delete(Long id){
        return delete(read(id));
    }
}
