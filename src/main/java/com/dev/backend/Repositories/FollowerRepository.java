package com.dev.backend.Repositories;

import com.dev.backend.Entities.Follower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface FollowerRepository extends JpaRepository<Follower, Integer> {

    @Transactional
    @Modifying
    @Query(value = "delete from FOLLOWER f where f.BEING_FOLLOWED_ID = ?1 and f.FOLLOWER_ID = ?2", nativeQuery = true)
    void unfollow(Integer beingFollowed, Integer follower);

}
