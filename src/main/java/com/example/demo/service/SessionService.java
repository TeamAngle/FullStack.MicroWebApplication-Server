package com.example.demo.service;

import com.example.demo.models.Session;
import com.example.demo.models.Tag;
import com.example.demo.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SessionService {

    @Autowired
    SessionRepository repository;

    public Session read(){
        return repository.findById(1l).get();

    }

    public Session update(Session newSession){
        Session sessionInDatabase = read();
        sessionInDatabase.setUserId(newSession.getUserId());
        return repository.save(sessionInDatabase);
    }
}
