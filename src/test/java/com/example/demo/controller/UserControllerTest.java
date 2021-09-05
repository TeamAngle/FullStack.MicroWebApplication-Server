package com.example.demo.controller;

import com.example.demo.models.User;
import com.example.demo.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserControllerTest {

    @InjectMocks
    UserController userController;

    @Mock
    UserService service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void read() {
        //given
        User user = new User();
        ResponseEntity<User> expected = new ResponseEntity<>(user, HttpStatus.OK);

        //when
        Mockito.doReturn(user).when(service).read(Mockito.anyLong());
        ResponseEntity<User> actual = userController.read(Mockito.anyLong());

        //Then
        assertEquals(expected,actual);
    }

    @Test
    void readAll() {
        //given
        List<User> userList = new ArrayList<>();
        ResponseEntity<List<User>> expected = new ResponseEntity<>(userList,HttpStatus.OK);

        //when
        Mockito.doReturn(userList).when(service).readAll();
        ResponseEntity<List<User>> actual = userController.readAll();

        //Then
        assertEquals(expected,actual);
    }

    @Test
    void create() {
        //given
        User user = new User();
        ResponseEntity<User> expected = new ResponseEntity<>(user,HttpStatus.CREATED);

        //when
        Mockito.doReturn(user).when(service).create(user);
        ResponseEntity<User> actual = userController.create(user);

        //Then
        assertEquals(expected,actual);
    }

    @Test
    void update() {
        //given
        User user = new User();
        ResponseEntity<User> expected = new ResponseEntity<>(user,HttpStatus.OK);

        //when
        Mockito.when(service.update(5L, user)).thenReturn(user);

        ResponseEntity<User> actual = userController.update(5L,user);

        //Then
        assertEquals(expected,actual);
    }

    @Test
    void delete() {
        //given
        User user = new User();
        ResponseEntity<User> expected = new ResponseEntity<>(user,HttpStatus.OK);

        //when
        Mockito.doReturn(user).when(service).delete(Mockito.anyLong());
        ResponseEntity<User> actual = userController.delete(Mockito.anyLong());

        //Then
        assertEquals(expected,actual);
    }
}