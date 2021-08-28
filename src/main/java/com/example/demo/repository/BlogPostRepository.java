package com.example.demo.repository;

import com.example.demo.models.BlogPost;
import com.example.demo.models.Tag;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogPostRepository extends CrudRepository<BlogPost, Long> {

    @Query(value = "SELECT * FROM blog_post b WHERE b.user_id = :userId", nativeQuery = true)
    List<BlogPost> findByUser(@Param("userId") Long userId);

    @Query(value = "SELECT * FROM blog_post WHERE tag_id = :tagId", nativeQuery = true)
    List<BlogPost> findByTag(@Param("tagId") Long tagId);
}
