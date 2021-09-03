package com.example.demo.repository;

//import com.example.demo.models.Recipe;
import com.example.demo.model.entity.Tag;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagRepository extends CrudRepository<Tag, Long> {

    @Query(value = "SELECT blog_id FROM tag t JOIN blogpost_tag bpt ON t.id = bpt.tag_id WHERE t.id = :tagId", nativeQuery = true)
        List<Long> findBlogIdsByTag(@Param("tagId") Long tagId);

}
