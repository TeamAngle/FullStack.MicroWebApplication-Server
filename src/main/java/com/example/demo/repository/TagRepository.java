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

    @Query(value = "SELECT blog_post_id FROM tags t JOIN blogposts_tags tbp ON t.id = tbp.tags_id WHERE t.id = :tagId", nativeQuery = true)
        List<Long> findBlogIdsByTag(@Param("tagId") Long tagId);

}
