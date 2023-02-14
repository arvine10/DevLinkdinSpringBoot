package com.dev.backend.Controllers;

import com.dev.backend.Entities.Comment;
import com.dev.backend.Entities.Post;
import com.dev.backend.Entities.Users;
import com.dev.backend.Repositories.CommentRepository;
import com.dev.backend.Services.CommentService;
import com.dev.backend.Services.PostService;
import com.dev.backend.Services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(value = "http://localhost:4200")
@RestController
@RequestMapping("comment")
public class CommentController {

    private PostService postService;
    private UserService userService;
    private CommentService commentService;

    private CommentRepository commentRepository;

    public CommentController(PostService postService,
                             UserService userService,
                             CommentService commentService,
                             CommentRepository commentRepository) {
        this.postService = postService;
        this.userService = userService;
        this.commentService = commentService;
        this.commentRepository = commentRepository;
    }


    @PostMapping("add")
    public ResponseEntity<String> addComment(@RequestBody Comment com,
                                             @RequestParam Integer userId,
                                             @RequestParam Integer postId){
        Users foundUser = this.userService.getUserById(userId);
        Post foundPost = this.postService.getPostById(postId);
        HttpStatus status;
        if (foundUser!=null && foundPost!=null){
            status = HttpStatus.OK;
            com.setProfile(foundUser);
            com.setPost(foundPost);
            this.commentService.addComment(com);
            return new ResponseEntity(com,status);
        }
        status = HttpStatus.BAD_REQUEST;
        return new ResponseEntity(status);
    }



    @GetMapping("all")
    public List<Object> getAllCommentsPerPost(@RequestParam Integer postId){
        return this.commentRepository.findCommentsForPost(postId);
    }






}
