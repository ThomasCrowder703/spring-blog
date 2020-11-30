package com.codeup.blogapplication;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class PostController {
    @GetMapping("/posts/index")
    public String index(Model model){
        Posts postOne = new Posts("Post one", "Who knows");
        Posts postTwo = new Posts("Post Two", "I know");
        ArrayList<Posts> postArray = new ArrayList<>();
        postArray.add(postOne);
        postArray.add(postTwo);
        model.addAttribute("thePosts", postArray);
        return "posts/index";
    }

    @GetMapping("/posts/show")
    public String singlePost(Model model){
        Posts post = new Posts();
        post.setTitle("First post");
        post.setBody("Blah blah");
        model.addAttribute("postHead", post.getTitle());
        model.addAttribute("postBody", post.getBody());
        return "/posts/show";
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String viewCreatePost(){
        return "This is the viewing form for creating a post";
    }

    @PostMapping("posts/create")
    @ResponseBody
    public String createPost(){
        return "This is the form for creating a post";
    }

}
