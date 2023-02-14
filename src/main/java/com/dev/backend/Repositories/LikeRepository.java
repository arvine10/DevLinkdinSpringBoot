package com.dev.backend.Repositories;

import com.dev.backend.Entities.Likes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeRepository extends JpaRepository<Likes, Integer> {

    @Query(value = "select * from LIKES l where l.POST_ID = ?1 and l.USER_ID = ?2", nativeQuery = true)
    Likes getLikeByPostIdAndUserId(Integer postId, Integer userId);
}
