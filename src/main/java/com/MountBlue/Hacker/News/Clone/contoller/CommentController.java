package com.MountBlue.Hacker.News.Clone.contoller;

import com.MountBlue.Hacker.News.Clone.dto.CommentDto;
import com.MountBlue.Hacker.News.Clone.model.Comment;
import com.MountBlue.Hacker.News.Clone.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/HackerNews")
public class CommentController {
    private final CommentService commentService;
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/getAllComment")
    public ResponseEntity<String> getAllCommentByPost(@RequestParam(required = false) Integer postId) {
        if (postId == null) {
            return commentService.getAllComment();
        } else {
            return commentService.getAllCommentByPost(postId);
        }
    }

    @PostMapping("/saveComment")
    public ResponseEntity<String> saveCommentData(@RequestBody CommentDto commentDto){
        Comment comment = new Comment();
        comment.setName(commentDto.getName());
        comment.setEmail(commentDto.getEmail());
        comment.setComment(commentDto.getComment());
        return commentService.saveCommentData(comment);
    }

    @DeleteMapping("/deleteComment")
    public ResponseEntity<String> deleteCommentById(@RequestParam Integer commentId){
        if (commentId == null){
            return new ResponseEntity<>("No Comment ID was given.", HttpStatus.NOT_FOUND);
        }else {
            commentService.deleteCommentById(commentId);
            return new ResponseEntity<>("Comment deleted", HttpStatus.OK);
        }
    }

    @PutMapping("/updateComment")
    public ResponseEntity<String> updatePost(@RequestParam int commentId,@RequestBody CommentDto commentDto){
        return commentService.UpdateCommentById(commentId,commentDto);
    }
}
