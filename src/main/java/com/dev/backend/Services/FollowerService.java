package com.dev.backend.Services;

import com.dev.backend.Entities.Follower;
import com.dev.backend.Repositories.FollowerRepository;
import org.springframework.stereotype.Service;

@Service
public class FollowerService {

    private FollowerRepository followerRepository;

    public FollowerService(FollowerRepository followerRepository) {
        this.followerRepository = followerRepository;
    }


    public Follower addFollower(Follower follower){
        return this.followerRepository.save(follower);
    }


    public void unfollow(Integer beingFollowed, Integer follower){
        this.followerRepository.unfollow(beingFollowed, follower);
    }






}
