package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tagController")
public class TagController {

    @Autowired
    private TagService service;

    @GetMapping(value = "/read/{id}")
    public ResponseEntity<Tag> read(@PathVariable Long id){
        return new ResponseEntity<>(service.read(id), HttpStatus.OK);
    }

    @GetMapping(value = "/read")
    public ResponseEntity<List<Tag>> readAll(){
        return new ResponseEntity<>(service.readAll(), HttpStatus.OK);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Tag> create(@RequestBody Tag tag){
        return new ResponseEntity<>(service.create(tag), HttpStatus.CREATED);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Tag> update(@PathVariable Long id, @RequestBody Tag tag){
        return new ResponseEntity<>(service.update(id, tag), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Tag> delete(@PathVariable Long id){
        return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
    }
}
