package com.MountBlue.Hacker.News.Clone.service;

import com.MountBlue.Hacker.News.Clone.dto.CommentDto;
import com.MountBlue.Hacker.News.Clone.model.Comment;
import com.MountBlue.Hacker.News.Clone.model.Post;
import com.MountBlue.Hacker.News.Clone.respository.CommentRepository;
import com.MountBlue.Hacker.News.Clone.respository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    public CommentService(CommentRepository commentRepository,PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }


    public List<Comment> getAllComment() {
        return commentRepository.findAll();
    }

    public List<Comment> getAllCommentByPost(int postId){
        List<Comment> commentList = new ArrayList<>();
        if(postRepository.findById(postId).isPresent()) {
            Post post = postRepository.findById(postId).get();
            commentList = post.getCommentId();
            return commentList;
        }else{
            return commentList;
        }
    }

    public void saveCommentData(Comment comment) {
        commentRepository.save(comment);
    }

    public void deleteCommentById(int commentId) {
            commentRepository.deleteById(commentId);
    }

    public void UpdateCommentById(int commentId, CommentDto commentDto) {
        if (commentRepository.findById(commentId).isPresent()) {
            Comment newComment = commentRepository.findById(commentId).get();
            newComment.setName(commentDto.getName());
            newComment.setEmail(commentDto.getEmail());
            newComment.setComment(commentDto.getComment());
            commentRepository.save(newComment);
        }
    }

    public List<Comment> getCommentById(Integer commentId) {
        return commentRepository.findById(commentId).stream().toList();
    }
}
