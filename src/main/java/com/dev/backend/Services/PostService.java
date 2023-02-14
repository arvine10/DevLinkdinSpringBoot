package com.dev.backend.Services;

import com.dev.backend.Entities.Post;
import com.dev.backend.Entities.Users;
import com.dev.backend.Repositories.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class PostService {
    private PostRepository postRepository;


    public PostService(PostRepository postRepository){
        this.postRepository = postRepository;
    }

    public List<Object> getAllPosts(){
        return this.postRepository.getAllPosts();
    }

    public Post getPostById(Integer id){
        return this.postRepository.findById(id).orElse(null);
    }

    public Post addPost(Post post){
       return this.postRepository.save(post);
    }

    public Post updatePost(Post post){
        if (this.postRepository.findById(post.getId()).orElse(null)!=null){
            return this.postRepository.save(post);
        } return null;
    }


    public boolean deletePost(Post post){
        if (this.postRepository.findById(post.getId()).orElse(null)!=null){
            this.postRepository.delete(post);
            return true;
        } return false;
    }













}
