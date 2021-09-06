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

    public Session read(Long id){
        return repository.findById(id).get();

    }

    public Session update(Long id, Session newSession){
        Session sessionInDatabase = read(id);
        sessionInDatabase.setUserId(newSession.getUserId());
        return repository.save(sessionInDatabase);
    }
}
