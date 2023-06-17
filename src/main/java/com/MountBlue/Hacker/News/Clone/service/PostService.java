package com.MountBlue.Hacker.News.Clone.service;

import com.MountBlue.Hacker.News.Clone.dto.PostDto;
import com.MountBlue.Hacker.News.Clone.model.Post;
import com.MountBlue.Hacker.News.Clone.respository.PostRepository;
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

    public void savePostData(Post post) {
        postRepository.save(post);
    }

    public void deletePostById(int postId) {
        postRepository.deleteById(postId);

    }

    public void UpdatePostById(int postId, PostDto postDto) {
        if (postRepository.existsById(postId)) {
            Post newPost = postRepository.findById(postId).get();
            newPost.setName(postDto.getName());
            newPost.setContent(postDto.getContent());
            newPost.setCreatedBy(postDto.getCreatedBy());
            postRepository.save(newPost);
        }
    }

    public List<Post> getPostById(int postId) {
        List<Post> postList = postRepository.findById(postId).stream().toList();
        return postList;
    }
}
