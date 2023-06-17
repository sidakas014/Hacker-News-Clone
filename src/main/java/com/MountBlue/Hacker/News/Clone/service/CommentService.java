package com.MountBlue.Hacker.News.Clone.service;

import com.MountBlue.Hacker.News.Clone.dto.CommentDto;
import com.MountBlue.Hacker.News.Clone.model.Comment;
import com.MountBlue.Hacker.News.Clone.model.Post;
import com.MountBlue.Hacker.News.Clone.respository.CommentRepository;
import com.MountBlue.Hacker.News.Clone.respository.PostRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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
        List<Comment> commentList = commentRepository.findAll();
        return commentList;
    }

    public List<Comment> getAllCommentByPost(int postId){
            Post post = postRepository.findById(postId).get();
            List<Comment> commentList =post.getCommentId();
            return commentList;
        }

    public void saveCommentData(Comment comment) {
        commentRepository.save(comment);
    }

    public void deleteCommentById(int commentId) {
            commentRepository.deleteById(commentId);
    }

    public void UpdateCommentById(int commentId, CommentDto commentDto) {
        if (commentRepository.existsById(commentId)) {
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
