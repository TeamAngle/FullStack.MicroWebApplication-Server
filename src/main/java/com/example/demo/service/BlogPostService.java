package com.example.demo.service;

import com.example.demo.models.BlogPost;
import com.example.demo.models.Tag;
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

    public BlogPost create(BlogPost blogPost){
        List<Tag> blogTags = blogPost.getTags();
        if(blogPost.getTags() != null) {
            for(Tag blogTag : blogTags) {
                String tagName = blogTag.getName();
                if(tagRepository.existsByTagName(tagName) == 1) {
                    Long tagId = tagRepository.findIdByTag(blogTag.getName());
                    blogTag.setId(tagId);
                } else tagRepository.save(blogTag);
            }
        }
        return repository.save(blogPost);
    }

    public BlogPost read(Long id){
        BlogPost blogPost = repository.findById(id).get();
        List<Long> tagIds = repository.findTagIdsByBlog(blogPost.getId());
        blogPost.setTags(convertIdToTag(tagIds));
        return blogPost;
    }

    public List<BlogPost> readAll(){
        Iterable<BlogPost> blogPostsIterable = repository.findAll();
        List<BlogPost> result = new ArrayList<>();
        blogPostsIterable.forEach(result::add);
        for(BlogPost blogPost : result) {
            List<Long> tagIds = repository.findTagIdsByBlog(blogPost.getId());
            blogPost.setTags(convertIdToTag(tagIds));
        }
        return result;
    }

    public List<Tag> convertIdToTag(List<Long> blogPostIds) {
        List<Tag> tagList = new ArrayList<>();
        for(Long id : blogPostIds) {
            Tag tag = tagRepository.findById(id).get();
            tagList.add(tag);
        }
        return tagList;
    }

    public BlogPost update(Long id, BlogPost newBlogPost){
        BlogPost blogPostInDatabase = read(id);
        blogPostInDatabase.setImageUrl(newBlogPost.getImageUrl());
        blogPostInDatabase.setTitle(newBlogPost.getTitle());
        blogPostInDatabase.setContent(newBlogPost.getContent());
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
