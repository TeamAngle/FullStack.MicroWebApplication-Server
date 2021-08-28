package com.example.demo.service;

import com.example.demo.models.BlogPost;
import com.example.demo.models.User;
import com.example.demo.repository.BlogPostRepository;
import com.example.demo.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlogPostService {
    @Autowired
    BlogPostRepository repository;
    @Autowired
    TagRepository tagRepository;

    public BlogPost create(BlogPost blogPost){return repository.save(blogPost);}

    public BlogPost read(Long id){
        BlogPost blogPost = repository.findById(id).get();
        blogPost.setTags(tagRepository.findByBlogPost(id));
        return blogPost;
    }

    public List<BlogPost> readAll(){
        Iterable<BlogPost> blogPostsIterable = repository.findAll();
        List<BlogPost> result = new ArrayList<>();
        blogPostsIterable.forEach(result::add);
        for(BlogPost blogPost : result) {
            blogPost.setTags(tagRepository.findByBlogPost(blogPost.getId()));
        }
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
