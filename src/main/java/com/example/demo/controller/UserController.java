package com.example.demo.controller;

import com.example.demo.service.UserService;
import com.example.demo.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/userController")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping(value = "/read/{id}")
    public ResponseEntity<User> read(@PathVariable Long id){
        return new ResponseEntity<>(service.read(id), HttpStatus.OK);
    }

    @GetMapping(value = "/read")
    public ResponseEntity<List<User>> readAll(){
        return new ResponseEntity<>(service.readAll(), HttpStatus.OK);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<User> create(@RequestBody User user){
        return new ResponseEntity<>(service.create(user), HttpStatus.CREATED);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User user){
        return new ResponseEntity<>(service.update(id, user), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<User> delete(@PathVariable Long id){
        return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
    }
}
