package com.example.demo.service;

//import com.example.demo.models.Recipe;


class BlogPostServiceTest {
//
//    @InjectMocks
//    BlogPostService blogPostService;
//
//    @Mock
//    BlogPostRepository repository;
//
//    @Mock
//    TagRepository tagRepository;
//
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.initMocks(this);
//    }
//
//    @Test
//    void create() {
//        //given
//        BlogPost blogPost = new BlogPost();
//        BlogPost expected = new BlogPost();
//        Mockito.doReturn(expected).when(repository).save(blogPost);
//
//        //when
//        BlogPost Actual = blogPostService.create(blogPost);
//
//        //Then
//        Assert.assertEquals(expected,Actual);
//
//    }
//
//    @Test
//    void read()  {
//        //given
//        List<Tag> tags = new ArrayList<>();
//        BlogPost blogPost = new BlogPost();
//        BlogPost expected = new BlogPost();
//
//        //when
//        when(repository.findById(anyLong())).thenReturn(Optional.of(expected));
//        when(tagRepository.findByBlogPost(anyLong())).thenReturn(tags);
//        BlogPost Actual = blogPostService.read(anyLong());
//
//        //Then
//        Assert.assertEquals(expected,Actual);
//    }
//
//    @Test
//    void readAll() {
//        //given
//        BlogPost blogPost = new BlogPost();
//        List<BlogPost> result = new ArrayList<>();
//        result.add(new BlogPost());
//        List expected = new ArrayList();
//
//
//        //when
//        when(repository.findAll()).thenReturn(expected);
//        when(tagRepository.findByBlogPost(blogPost.getId())).thenReturn(expected);
//        List Actual = blogPostService.readAll();
//
//        //Then
//        Assert.assertEquals(expected,Actual);
//
//    }
//
//    @Test
//    void update() {
//
//    }
//
//    @Test
//    void delete() {
//    }
//
//    @Test
//    void testDelete() {
//
//
//
//
//    }
}