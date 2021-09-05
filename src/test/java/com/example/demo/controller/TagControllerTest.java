package com.example.demo.controller;

import com.example.demo.models.Tag;
import com.example.demo.service.TagService;
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

class TagControllerTest {

    @InjectMocks
    TagController tagController;

    @Mock
    TagService service;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void read() {
        //given
        Tag tag = new Tag();
        ResponseEntity<Tag> expected = new ResponseEntity<>(tag, HttpStatus.OK);

        //when
        Mockito.doReturn(tag).when(service).read(Mockito.anyLong());
        ResponseEntity<Tag> actual = tagController.read(Mockito.anyLong());

        //Then
        assertEquals(expected,actual);
    }

    @Test
    void readAll() {
        //given
        List<Tag> tagList = new ArrayList<>();
        ResponseEntity<List<Tag>> expected = new ResponseEntity<>(tagList,HttpStatus.OK);

        //when
        Mockito.doReturn(tagList).when(service).readAll();
        ResponseEntity<List<Tag>> actual = tagController.readAll();

        //Then
        assertEquals(expected,actual);
    }

    @Test
    void create() {
        //given
        Tag tag = new Tag();
        ResponseEntity<Tag> expected = new ResponseEntity<>(tag,HttpStatus.CREATED);

        //when
        Mockito.doReturn(tag).when(service).create(tag);
        ResponseEntity<Tag> actual = tagController.create(tag);

        //Then
        assertEquals(expected,actual);
    }

    @Test
    void update() {
        //given
        Tag tag = new Tag();
        ResponseEntity<Tag> expected = new ResponseEntity<>(tag,HttpStatus.OK);

        //when
        Mockito.when(service.update(5L, tag)).thenReturn(tag);

        ResponseEntity<Tag> actual = tagController.update(5L,tag);

        //Then
        assertEquals(expected,actual);
    }

    @Test
    void delete() {
        //given
        Tag tag = new Tag();
        ResponseEntity<Tag> expected = new ResponseEntity<>(tag,HttpStatus.OK);

        //when
        Mockito.doReturn(tag).when(service).delete(Mockito.anyLong());
        ResponseEntity<Tag> actual = tagController.delete(Mockito.anyLong());

        //Then
        assertEquals(expected,actual);
    }
}