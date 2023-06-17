package com.MountBlue.Hacker.News.Clone.service;

import com.MountBlue.Hacker.News.Clone.dto.PostDto;
import com.MountBlue.Hacker.News.Clone.model.Post;
import com.MountBlue.Hacker.News.Clone.respository.PostRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository){
        this.postRepository=postRepository;
    }

    public List<Post> getAllPost() {
        return postRepository.findAll();
    }

    public ResponseEntity<String> savePostData(Post post) {
        postRepository.save(post);
        return new ResponseEntity<>("Data is saved", HttpStatus.CREATED);
    }

    public ResponseEntity<String> deletePostById(int postId) {
        if(postRepository.existsById(postId)){
            postRepository.deleteById(postId);
            return new ResponseEntity<>("Post has been deleted successfully",HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Post has been not found",HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<String> UpdatePostById(int postId, PostDto postDto){
        if(postRepository.existsById(postId)){
            Post newPost = postRepository.findById(postId).get();
            newPost.setName(postDto.getName());
            newPost.setContent(postDto.getContent());
            newPost.setCreatedBy(postDto.getCreatedBy());
            postRepository.save(newPost);
            return new ResponseEntity<>("Post Has been updated",HttpStatus.ACCEPTED);
        }else{
            return new ResponseEntity<>("Post with id is not present please create the new post",HttpStatus.NOT_FOUND);
        }
    }
}
