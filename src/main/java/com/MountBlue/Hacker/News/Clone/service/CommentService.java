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


    public ResponseEntity<String> getAllComment() {
        List<Comment> commentList = commentRepository.findAll();
        return new ResponseEntity<>("List of all comment present on all posts:" + commentList, HttpStatus.OK);
    }
    public ResponseEntity<String> getAllCommentByPost(int postId){
        if(postRepository.existsById(postId)) {
            Post post = postRepository.findById(postId).get();
            List<Comment> commentList =post.getCommentId();
            return new ResponseEntity<>("List of comment :"+commentList,HttpStatus.OK) ;
        }else{
            return new ResponseEntity<>("Post With the id "+postId+"Is not available",HttpStatus.NOT_FOUND);
        }

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

    public ResponseEntity<String> UpdateCommentById(int commentId, CommentDto commentDto){
        if(commentRepository.existsById(commentId)){
            Comment newComment = commentRepository.findById(commentId).get();
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
