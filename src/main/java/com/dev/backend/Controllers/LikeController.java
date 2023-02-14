package com.dev.backend.Controllers;

import com.dev.backend.Entities.Likes;
import com.dev.backend.Entities.Post;
import com.dev.backend.Entities.Users;
import com.dev.backend.Services.LikeService;
import com.dev.backend.Services.PostService;
import com.dev.backend.Services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(value = "http://localhost:4200")
@RestController
@RequestMapping("like")

public class LikeController {

    LikeService likeService;
    UserService userService;
    PostService postService;

    public LikeController(LikeService likeService, UserService userService, PostService postService) {
        this.likeService = likeService;
        this.userService = userService;
        this.postService = postService;
    }

    @PostMapping("add")
    public ResponseEntity<String> addLike(@RequestParam Integer postId, @RequestParam Integer userId){
        Users foundUser = this.userService.getUserById(userId);
        Post foundPost = this.postService.getPostById(postId);
        HttpStatus status;

        Likes alreadyLiked = likeService.getLikeByPostIdAndUserId(postId,userId);
        if (alreadyLiked!=null){
            status = HttpStatus.OK;
            likeService.deleteLike(alreadyLiked);
            return new ResponseEntity(status);
        }

        if (foundPost!=null && foundPost!=null){
            Likes likes = new Likes();
            likes.setPosts(foundPost);
            likes.setUsers(foundUser);
            likeService.addLike(likes);
            status = HttpStatus.OK;
            return new ResponseEntity(status);
        }
        status = HttpStatus.BAD_REQUEST;
        return new ResponseEntity(status);
    }




}
