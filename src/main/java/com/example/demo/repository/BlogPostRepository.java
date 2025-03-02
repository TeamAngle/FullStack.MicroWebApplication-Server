package com.example.demo.repository;

import com.example.demo.models.BlogPost;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogPostRepository extends CrudRepository<BlogPost, Long> {

    @Query(value = "SELECT * FROM blogposts b WHERE b.user_id = :userId", nativeQuery = true)
    List<BlogPost> findByUser(@Param("userId") Long userId);

    @Query(value = "SELECT tag_id FROM blogposts bp JOIN blogpost_tags tbp ON bp.id = tbp.blog_id WHERE bp.id = :postId", nativeQuery = true)
    List<Long> findTagIdsByBlog(@Param("postId") Long postId);

    @Query(value = "INSERT INTO blogpost_tags (blog_id, tag_id) VALUES (:blogId, :tagId)", nativeQuery = true)
    void populateBlogTagsTable(@Param("blogId") Long blogId, @Param("tagId") Long tagId);

    @Query(value = "SELECT * FROM blogposts WHERE title = :title", nativeQuery = true)
    BlogPost findByTitle(@Param("title") String title);

}
