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

    private CommentRepository commentRepository;

    private PostRepository postRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public CommentService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Comment> getAllCommentByPost(int postId) {
        Post post = postRepository.findById(postId).get();
        return post.getCommentId();
    }



    public ResponseEntity<String> saveCommentData(Comment comment) {
        commentRepository.save(comment);
        return new ResponseEntity<>("Comment is saved", HttpStatus.CREATED);
    }

    public ResponseEntity<String> deleteCommentById(int commentId) {
        if(commentRepository.existsById(commentId)){
            commentRepository.deleteById(commentId);
            return new ResponseEntity<>("Comment has been deleted successfully",HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Comment has been not found",HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<String> UpdateCommentById(int postId, CommentDto commentDto){
        if(commentRepository.existsById(postId)){
            Comment newComment = commentRepository.findById(postId).get();
            newComment.setName(commentDto.getName());
            newComment.setEmail(commentDto.getEmail());
            newComment.setComment(commentDto.getComment());
            commentRepository.save(newComment);
            return new ResponseEntity<>("Comment Has been updated",HttpStatus.ACCEPTED);
        }else{
            return new ResponseEntity<>("Comment with id is not present please create the new post",HttpStatus.NOT_FOUND);
        }
    }
}
