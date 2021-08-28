package com.example.demo.service;

import com.example.demo.models.User;
import com.example.demo.repository.BlogPostRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;
    @Autowired
    private BlogPostRepository blogPostRepository;

    public User create(User user){ return repository.save(user); }

    public User read(Long id){
        User user = repository.findById(id).get();
        user.setBlogPostList(blogPostRepository.findByUser(id));
        return user;
    }

    public List<User> readAll(){
        Iterable<User> userIterable = repository.findAll();
        List<User> result = new ArrayList<>();
        userIterable.forEach(result::add);
        for(User user : result) {
            user.setBlogPostList(blogPostRepository.findByUser(user.getId()));
        }
        return result;
    }

    public User update(Long id, User newUser){
        User userInDatabase = read(id);
        userInDatabase.setName(newUser.getName());
        userInDatabase.setPassword(newUser.getPassword());
        userInDatabase.setPostCount(newUser.getPostCount());
        return repository.save(userInDatabase);
    }

    public User delete(User user){
        repository.delete(user);
        return user;
    }

    public User delete(Long id){
        return delete(read(id));
    }
}


