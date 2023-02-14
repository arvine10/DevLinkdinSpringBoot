package com.dev.backend.Repositories;

import com.dev.backend.Entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {

    @Query(value = "select u.USER_NAME, u.PROFILE_IMAGE, c.DESCRIPTION  from POST p  inner join COMMENT c on p.ID  = c.POST_ID inner join USERS u on u.id = c.USER_ID and p.ID = ?1", nativeQuery = true)
    List<Object> findCommentsForPost(Integer postId);




}
