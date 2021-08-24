package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TagService {
    @Autowired
    private TagRepository repository;

    public Tag create(Tag tag){ return repository.save(tag); }

    public Tag read(Long id){ return repository.findById(id).get(); }

    public List<Tag> readAll(){
        Iterable<Tag> tagIterable = repository.findAll();
        List<Tag> result = new ArrayList<>();
        tagIterable.forEach(result::add);
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
