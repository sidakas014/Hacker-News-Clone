package com.MountBlue.Hacker.News.Clone.Controller;

import com.MountBlue.Hacker.News.Clone.model.Post;
import com.MountBlue.Hacker.News.Clone.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/api/v1/HackerNews")
public class PostController {
    private final PostService postService;
    public PostController(PostService postService){
        this.postService=postService;
    }
    @GetMapping({"/home","/"})
    public String getHomePage(Model model){
        List<Post> postList = postService.getAllPost();
        model.addAttribute("postList",postList);
        return "home";
    }
    @GetMapping("/postView/{id}")
    public String postView(Model model, @PathVariable("postId") int id ){
        return "Hello";
    }

    @GetMapping("/search")
    public String search(@RequestParam(value = "search", defaultValue = "") String search, Model model){
       List<Post> postList = postService.search(search, model);
        model.addAttribute("search", search);
        model.addAttribute("postList",postList);
        return "search";
    }
}
