package com.dev.backend.Controllers;

import com.dev.backend.Entities.Post;
import com.dev.backend.Entities.Users;
import com.dev.backend.Services.PostService;
import com.dev.backend.Services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(value = "http://localhost:4200")
@RestController
@RequestMapping("post")
public class PostController {

    private PostService postService;
    private UserService userService;

    public PostController(PostService postService, UserService userService){
        this.postService = postService;
        this.userService = userService;
    }

    @GetMapping("all")
    public List<Object> getAllPosts(){
        return this.postService.getAllPosts();
    }


    @GetMapping("{id}")
    public Post getPostByID(@PathVariable Integer id){
        return this.postService.getPostById(id);
    }

    @PostMapping("add")
    public ResponseEntity<String> addPost(@RequestBody Post post, @RequestParam Integer userId){
        Users foundUser = this.userService.getUserById(userId);
        HttpStatus status;
        if (foundUser != null){
            status = HttpStatus.OK;
            post.setUser(foundUser);
            this.postService.addPost(post);
            return new ResponseEntity(post,status);
        } else {
            status = HttpStatus.BAD_REQUEST;
            return new ResponseEntity(status);
        }
    }

    @PutMapping("update")
    public ResponseEntity<Post> updatePost(@RequestBody Post post){
        Post foundPost = this.postService.getPostById(post.getId());
        HttpStatus status;
        if (foundPost != null){
            status = HttpStatus.OK;
            this.postService.updatePost(post);
        } else status = HttpStatus.BAD_REQUEST;
        return new ResponseEntity(status);
    }


    @DeleteMapping("delete")
    public ResponseEntity<String> deletePost(@RequestBody Post post){
        boolean returnVal = this.postService.deletePost(post);
        HttpStatus status;
        if (returnVal == true) status = HttpStatus.OK;
        else status = HttpStatus.BAD_REQUEST;
        return new ResponseEntity(status);
    }



//    @PostMapping("like")
//    public ResponseEntity<String> addLike(@RequestParam Integer postId, @RequestParam Integer userId){
//        Users foundUser = this.userService.getUserById(userId);
//        Post foundPost = this.postService.getPostById(postId);
//        HttpStatus status;
//        if (foundPost!=null && foundPost!=null){
//            foundPost.setLikes(foundUser);
//            status = HttpStatus.OK;
//            this.postService.updatePost(foundPost);
//            return new ResponseEntity(status);
//        }
//        status = HttpStatus.BAD_REQUEST;
//        return new ResponseEntity(status);
//    }





}
