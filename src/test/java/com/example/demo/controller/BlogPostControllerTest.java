package com.example.demo.controller;

import com.example.demo.models.BlogPost;
import com.example.demo.service.BlogPostService;
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

class BlogPostControllerTest {

    @InjectMocks
    BlogPostController blogPostController;

    @Mock
    BlogPostService service;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void read() {
        //given
        BlogPost blogPost = new BlogPost();
        ResponseEntity<BlogPost> expected = new ResponseEntity<>(blogPost,HttpStatus.OK);

        //when
        Mockito.doReturn(blogPost).when(service).read(Mockito.anyLong());
        ResponseEntity<BlogPost> actual = blogPostController.read(Mockito.anyLong());

        //Then
        assertEquals(expected,actual);
    }

    @Test
    void readAll() {
        //given
        List<BlogPost> blogPostList = new ArrayList<>();
        ResponseEntity<List<BlogPost>> expected = new ResponseEntity<>(blogPostList,HttpStatus.OK);

        //when
        Mockito.doReturn(blogPostList).when(service).readAll();
        ResponseEntity<List<BlogPost>> actual = blogPostController.readAll();

        //Then
        assertEquals(expected,actual);

    }

    @Test
    void create() {
        //given
        BlogPost blogPost = new BlogPost();
        ResponseEntity<BlogPost> expected = new ResponseEntity<>(blogPost,HttpStatus.CREATED);

        //when
        Mockito.doReturn(blogPost).when(service).create(blogPost);
        ResponseEntity<BlogPost> actual = blogPostController.create(blogPost);

        //Then
        assertEquals(expected,actual);

    }

    @Test
    void updateTest() {
        //given
        BlogPost blogPost = new BlogPost();
        ResponseEntity<BlogPost> expected = new ResponseEntity<>(blogPost,HttpStatus.OK);

        //when
        Mockito.when(service.update(5L, blogPost)).thenReturn(blogPost);

        ResponseEntity<BlogPost> actual = blogPostController.update(5L,blogPost);

        //Then
        assertEquals(expected,actual);
    }

    @Test
    void delete() {
        //given
        BlogPost blogPost = new BlogPost();
        ResponseEntity<BlogPost> expected = new ResponseEntity<>(blogPost,HttpStatus.OK);

        //when
        Mockito.doReturn(blogPost).when(service).delete(Mockito.anyLong());
        ResponseEntity<BlogPost> actual = blogPostController.delete(Mockito.anyLong());

        //Then
        assertEquals(expected,actual);
    }
}