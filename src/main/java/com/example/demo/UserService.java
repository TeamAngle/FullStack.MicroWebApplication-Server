package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public User create(User user){ return repository.save(user); }

    public User read(Long id){ return repository.findById(id).get(); }

    public List<User> readAll(){
        Iterable<User> userIterable = repository.findAll();
        List<User> result = new ArrayList<>();
        userIterable.forEach(result::add);
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
