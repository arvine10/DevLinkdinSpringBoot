package com.dev.backend.Services;

import com.dev.backend.Entities.Likes;
import com.dev.backend.Repositories.LikeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikeService {

    LikeRepository likeRepository;

    public LikeService(LikeRepository likeRepository) {
        this.likeRepository = likeRepository;
    }

    public List<Likes> getAllLikes(){
        return this.likeRepository.findAll();
    }

    public Likes addLike(Likes likes){
        return this.likeRepository.save(likes);
    }


    public Likes getLikeByPostIdAndUserId(Integer postId, Integer userId){
        return this.likeRepository.getLikeByPostIdAndUserId(postId,userId);
    }


    public void deleteLike(Likes like){
        likeRepository.delete(like);
    }



}
