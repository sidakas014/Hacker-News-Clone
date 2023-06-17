package com.MountBlue.Hacker.News.Clone.Controller;

import com.MountBlue.Hacker.News.Clone.dto.CommentDto;
import com.MountBlue.Hacker.News.Clone.model.Comment;
import com.MountBlue.Hacker.News.Clone.service.CommentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/v1/HackerNews")
public class CommentController {
    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/getAllComment")
    public String getAllComment(Model model){
        List<Comment> comment = commentService.getAllComment();
        model.addAttribute("Comments", comment);
        return "home";
    }

    @GetMapping("/getAllCommentByPost")
    public String getAllCommentByPost(@RequestParam("postId") int postId, Model model){
        List<Comment> comment = commentService.getCommentById(postId);
        model.addAttribute("postComment", comment);
        return "home";
    }
    @PostMapping("/saveComment")
    public String saveCommentData(@RequestParam("postId") int postId,
                                  @RequestParam("name") String name,
                                  @RequestParam("email") String email,
                                  @RequestParam("comment") String comment, Model model){
        Comment newComment = new Comment();
        newComment.setName(name);
        newComment.setEmail(email);
        newComment.setComment(comment);
        commentService.saveCommentData(newComment);
        return "home";
    }

    @PutMapping("/updateComment")
    public String updateComment(@RequestParam("commentId") int commentId,
                                @RequestParam("comment") String comment, Model model){
        CommentDto updatedComment = new CommentDto();
        updatedComment.setComment(comment);
        commentService.UpdateCommentById(commentId, updatedComment);
        return "home";
    }
}
