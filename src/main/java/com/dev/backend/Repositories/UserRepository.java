package com.dev.backend.Repositories;

import com.dev.backend.Entities.Message;
import com.dev.backend.Entities.Users;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {

    @Query(value = "SELECT u.* FROM USERS  u inner join FOLLOWER f on f.FOLLOWER_ID = u.ID and f.BEING_FOLLOWED_ID = ?1", nativeQuery = true)
    public List<Users> getAllFollowers(Integer userId);

    @Query(value = "select u.* from  FOLLOWER f inner join USERS  u on f.BEING_FOLLOWED_ID = u.ID and f.FOLLOWER_ID = ?1", nativeQuery = true)
    List<Users> getWhoIAmFollowing(Integer userId);

    @Query(value = "select u.* from  USERS u where u.email= ?1 and u.password = ?2", nativeQuery = true)
    Users getUserByEmailAndPassword(String email, String password);

    @Query(value = "select p.ID as myLikedPosts from POST p inner join LIKES l on l.POST_ID = p.ID inner join USERS u on u.ID = l.USER_ID and u.ID = ?1", nativeQuery = true)
    List<Object> getMyLikedPosts(Integer userId);


}
