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
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

class BlogPostServiceTest {

    @InjectMocks
    BlogPostService blogPostService;

    @Mock
    BlogPostRepository repository;

    @Mock
    TagRepository tagRepository;



    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void create() {
        //given
        BlogPost blogPost = new BlogPost();
        BlogPost expected = new BlogPost();


        //when
        Mockito.doReturn(expected).when(repository).save(blogPost);
        BlogPost Actual = blogPostService.create(blogPost);

        //Then
        assertEquals(expected,Actual);

    }

    @Test
    void readTest()  {
        //given
        List<Long> id = new ArrayList<>();
        BlogPost blogPost = new BlogPost();
        BlogPost expected = new BlogPost();

        //when
        when(repository.findById(anyLong())).thenReturn(Optional.of(expected));
        when(repository.findTagIdsByBlog(blogPost.getId())).thenReturn(id);
        when(tagRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(new Tag()));
        BlogPost Actual = blogPostService.read(anyLong());

        //Then
        assertEquals(expected,Actual);
    }

    @Test
    void readAll() {
        //given
        BlogPost blogPost = new BlogPost();
        List<BlogPost> result = new ArrayList<>();
        result.add(new BlogPost());
        List<Long> tagIds = new ArrayList<>();
        List expected = new ArrayList();


        //when
        when(repository.findAll()).thenReturn(expected);
        when(repository.findTagIdsByBlog(blogPost.getId())).thenReturn(tagIds);

        List Actual = blogPostService.readAll();

        //Then
       assertEquals(expected,Actual);

    }

    @Test
    void update() {
        //given
        List<Long> id = new ArrayList<>();
        id.add(5L);
        id.add(6L);
        BlogPost newBlogPost = new BlogPost();
        newBlogPost.setImageUrl("abc.com");
        newBlogPost.setTitle("My Blog");
        newBlogPost.setContent(null);


        //when
        when(repository.findById(anyLong())).thenReturn(Optional.of(newBlogPost));
        when(repository.findTagIdsByBlog(newBlogPost.getId())).thenReturn(id);
        when(tagRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(new Tag()));
        when(repository.save(newBlogPost)).thenReturn(newBlogPost);

        BlogPost Actual = blogPostService.update(Mockito.anyLong(),newBlogPost);

        //Then
        assertEquals(newBlogPost,Actual);

    }

    @Test
    void delete() {
        //given
        BlogPost blogPost = new BlogPost();

        //when
        Mockito.when(repository.findById(2L)).thenReturn(Optional.of(blogPost));
        BlogPost Actual = blogPostService.delete(blogPost);

        //Then
        assertEquals(blogPost,Actual);

    }

    @Test
    void testDelete() {
        //given
        BlogPost blogPost = new BlogPost();

        //when
        Mockito.when(repository.findById(4L)).thenReturn(Optional.of(blogPost));
        BlogPost Actual = blogPostService.delete(4L);

        //Then
        assertEquals(blogPost,Actual);







    }
}