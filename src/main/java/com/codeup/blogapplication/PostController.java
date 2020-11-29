package com.codeup.blogapplication;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {
    @GetMapping("/posts")
    @ResponseBody
    public String index(){
        return "This will be the index page";
    }

    @RequestMapping(value = "/posts/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String singlePost(@PathVariable long id){
        return "This is an individual post with the id of " + id;
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
