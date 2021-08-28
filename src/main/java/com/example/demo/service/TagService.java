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
public class TagService {
    @Autowired
    private TagRepository repository;
    @Autowired
    private BlogPostRepository blogPostRepository;

    public Tag create(Tag tag){ return repository.save(tag); }

    public Tag read(Long id){
        Tag tag = repository.findById(id).get();
        tag.setBlogPosts(blogPostRepository.findByTag(id));
        return tag;
    }

    public List<Tag> readAll(){
        Iterable<Tag> tagIterable = repository.findAll();
        List<Tag> result = new ArrayList<>();
        tagIterable.forEach(result::add);
        for(Tag tag : result) {
            tag.setBlogPosts(blogPostRepository.findByTag(tag.getId()));
        }
        return result;
    }

    public Tag update(Long id, Tag newTag){
        Tag tagInDatabase = read(id);
        tagInDatabase.setName(newTag.getName());
        return repository.save(tagInDatabase);
    }

    public Tag delete(Tag tag){
        repository.delete(tag);
        return tag;
    }

    public Tag delete(Long id){
        return delete(read(id));
    }
}
