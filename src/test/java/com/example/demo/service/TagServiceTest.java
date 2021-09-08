package com.example.demo.service;

import com.example.demo.models.BlogPost;
import com.example.demo.models.Tag;
import com.example.demo.repository.BlogPostRepository;
import com.example.demo.repository.TagRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class TagServiceTest {
    @InjectMocks
    TagService tagService;

    @Mock
    TagRepository repository;

    @Mock
    BlogPostRepository blogPostRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void create() {
        //given
        Tag tag =  new Tag();
        Tag expected = new Tag();

        //when
        Mockito.doReturn(expected).when(repository).save(tag);
        Tag actual = tagService.create(tag);

        //Then
        assertEquals(expected,actual);
    }

    @Test
    void readTest() {
        //given
        List<Long> id = new ArrayList<>();
        Tag tag = new Tag();
        Tag expected = new Tag();

        //when
        Mockito.when(repository.findById(Mockito.anyLong())).thenReturn(java.util.Optional.of(expected));
        Mockito.when((repository.findBlogIdsByTag(tag.getId()))).thenReturn(id);
        Mockito.when(blogPostRepository.findById(Mockito.anyLong())).thenReturn(java.util.Optional.of(new BlogPost()));
        Tag actual = tagService.read(Mockito.anyLong());

        //Then
        assertEquals(expected,actual);
    }

    @Test
    void readAll() {
        //given
        Tag tag = new Tag();
        List<Tag> result = new ArrayList<>();
        result.add(new Tag());
        List<Long> tagIds = new ArrayList<>();
        List expected = new ArrayList();


        //when
        when(repository.findAll()).thenReturn(expected);
        when(repository.findBlogIdsByTag(tag.getId())).thenReturn(tagIds);

        List actual = tagService.readAll();

        //Then
        assertEquals(expected,actual);
    }

    @Test
    void convertIdToBlog() {
    }

    @Test
    void update() {
        //given
        List<Long> id = new ArrayList<>();
        id.add(5L);
        id.add(6L);
        Tag tag = new Tag();
        tag.setName("New Recipe");

        //when
        Mockito.when(repository.findById(Mockito.anyLong())).thenReturn(java.util.Optional.of(tag));
        Mockito.when((repository.findBlogIdsByTag(tag.getId()))).thenReturn(id);
        Mockito.when(blogPostRepository.findById(Mockito.anyLong())).thenReturn(java.util.Optional.of(new BlogPost()));
        Mockito.when( repository.save(tag)).thenReturn(tag);

        Tag actual = tagService.update(Mockito.anyLong(),tag);

        //Then
        assertEquals(tag,actual);

    }

    @Test
    void delete() {
        //given
        Tag tag = new Tag();

        //when
        Mockito.when(repository.findById(2L)).thenReturn(Optional.of(tag));
        Tag actual = tagService.delete(tag);

        //Then
        assertEquals(tag,actual);
    }

    @Test
    void testDelete() {
        //given
        Tag tag = new Tag();

        //when
        Mockito.when(repository.findById(4L)).thenReturn(Optional.of(tag));
        Tag actual = tagService.delete(4L);

        //Then
        assertEquals(tag,actual);
    }
}