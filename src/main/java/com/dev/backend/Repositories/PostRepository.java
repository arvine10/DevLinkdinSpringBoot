package com.dev.backend.Repositories;

import com.dev.backend.Entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

    @Query(value = "SELECT p.ID, p.DESCRIPTION, u.USER_NAME, u.PROFILE_IMAGE, p.IMAGE,  count(l.ID ) as numLikes   \n" +
            "FROM USERS  u inner join POST p \n" +
            "on p.USER_ID = u.ID \n" +
            " left join LIKES l\n" +
            "on l.POST_ID = p.ID \n" +
            "group by p.ID", nativeQuery = true)
    List<Object> getAllPosts();
}
