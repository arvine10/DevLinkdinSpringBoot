package com.dev.backend.Services;

import com.dev.backend.Entities.Comment;
import com.dev.backend.Repositories.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    private CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public Comment addComment(Comment com){
        return this.commentRepository.save(com);
    }


    public List<Comment> getAllComments(){
        return this.commentRepository.findAll();
    }





}
