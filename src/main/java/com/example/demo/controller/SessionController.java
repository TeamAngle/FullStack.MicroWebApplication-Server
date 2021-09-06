package com.example.demo.controller;

import com.example.demo.models.Session;
import com.example.demo.models.Tag;
import com.example.demo.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sessionController")
public class SessionController {

    @Autowired
    SessionService service;

    @GetMapping(value = "/read")
    public ResponseEntity<Session> read(){
        return new ResponseEntity<>(service.read(1l), HttpStatus.OK);
    }

    @PutMapping(value = "/update")
    public ResponseEntity<Session> update(@RequestBody Session session){
        return new ResponseEntity<>(service.update(1l, session), HttpStatus.OK);
    }
}
