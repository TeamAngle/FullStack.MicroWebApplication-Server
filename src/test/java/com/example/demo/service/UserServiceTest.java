package com.example.demo.service;

import com.example.demo.models.BlogPost;
import com.example.demo.models.User;
import com.example.demo.repository.BlogPostRepository;
import com.example.demo.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class UserServiceTest {

    @InjectMocks
    UserService userService;

    @Mock
    UserRepository repository;

    @Mock
    BlogPostRepository blogPostRepository;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void create() {
        //given
        User user = new User();
        User expected = new User();

        //when
        Mockito.doReturn(expected).when(repository).save(user);
        User Actual = userService.create(user);

        //Then
        assertEquals(expected,Actual);
    }

    @Test
    void readTest() {
        //given
        User expected = new User();
        User user = new User();
        List<Long> id  = new ArrayList<>();
        List<BlogPost> blogPostList = new ArrayList<>();
        blogPostList.add(new BlogPost());

        //when
        Mockito.when(repository.findById(Mockito.anyLong())).thenReturn(Optional.of(expected));
        Mockito.doReturn(blogPostList).when(blogPostRepository).findByUser(Mockito.anyLong());

        User actual = userService.read(Mockito.anyLong());

        //Then
        assertEquals(expected,actual);

    }

    @Test
    void readAll() {
        //given
        User user = new User();
        List<User> result = new ArrayList<>();
        result.add(new User());
        List expected = new ArrayList();


        //when
        when(repository.findAll()).thenReturn(expected);
        when(blogPostRepository.findByUser(user.getId())).thenReturn(expected);

        List actual = userService.readAll();

        //Then
        assertEquals(expected,actual);


    }

    @Test
    void update() {
        //given
        User user = new User();
        user.setName("Nisha");
        user.setPassword("abc123");
        user.setUserImage(null);
        user.setEmail("abc.com");

        //when
        Mockito.when(repository.findById(Mockito.anyLong())).thenReturn(Optional.of(user));
        Mockito.when(repository.save(user)).thenReturn(user);

        User actual = userService.update(Mockito.anyLong(),user);

        //Then
        assertEquals(user,actual);

    }

    @Test
    void delete() {
        //given
        User user = new User();

        //when
        Mockito.when(repository.findById(2L)).thenReturn(Optional.of(user));
        User actual = userService.delete(user);

        //Then
        assertEquals(user,actual);

    }

    @Test
    void testDelete() {
        //given
        User user = new User();

        //when
        Mockito.when(repository.findById(4L)).thenReturn(Optional.of(user));
        User actual = userService.delete(4L);

        //Then
        assertEquals(user,actual);
    }
}