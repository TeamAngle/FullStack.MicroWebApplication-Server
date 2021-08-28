package com.example.demo.repository;

import com.example.demo.models.BlogPost;
import com.example.demo.models.Recipe;
import com.example.demo.models.Tag;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagRepository extends CrudRepository<Tag, Long> {

    @Query(value = "SELECT * FROM tag WHERE tag.blog_post_id = :postId", nativeQuery = true)
    List<Tag> findByBlogPost(@Param("postId") Long blogPostId);
}
