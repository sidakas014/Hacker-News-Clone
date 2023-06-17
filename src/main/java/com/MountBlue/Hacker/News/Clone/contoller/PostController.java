package com.MountBlue.Hacker.News.Clone.contoller;

import com.MountBlue.Hacker.News.Clone.dto.PostDto;
import com.MountBlue.Hacker.News.Clone.model.Post;
import com.MountBlue.Hacker.News.Clone.service.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/HackerNews")
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/getAllPost")
    public List<Post> getAllPosts(){
        return postService.getAllPost();
    }

    @PostMapping("/savePost")
    public ResponseEntity<String> savePost(@RequestBody PostDto postDto){
        Post post = new Post();
        post.setName(postDto.getName());
        post.setContent(postDto.getContent());
        post.setCreatedBy(postDto.getCreatedBy());
        return postService.savePostData(post);
    }

    @DeleteMapping("/deletePost")
    public ResponseEntity<String> deletePost(@RequestParam int postId){
        return postService.deletePostById(postId);
    }

    @PutMapping("UpdatePost")
    public ResponseEntity<String> updatePost(@RequestParam int postId,@RequestBody PostDto postDto){
        return postService.UpdatePostById(postId,postDto);
    }

}
