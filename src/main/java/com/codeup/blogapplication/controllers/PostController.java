package com.codeup.blogapplication.controllers;

import com.codeup.blogapplication.models.Posts;
import com.codeup.blogapplication.models.User;
import com.codeup.blogapplication.repos.PostsRepository;
import com.codeup.blogapplication.repos.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class PostController {

    private final PostsRepository postsDao;
    private final UserRepository userDao;

    public PostController(PostsRepository postsDao, UserRepository userDao){
        this.postsDao = postsDao;
        this.userDao = userDao;
    }






    @GetMapping("/posts/index")
    public String index(Model model){
        model.addAttribute("posts", postsDao.findAll());
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String singlePost(@PathVariable long id, Model model){
        model.addAttribute("post", postsDao.getOne(id)); //show a single post
        return "/posts/show";
    }

    @GetMapping("/posts/create")
    public String viewCreatePost(){
        return "posts/new"; //This is the viewing form for creating a post
    }

    @PostMapping("posts/create")
    @ResponseBody
    public String createPost(
            @RequestParam(name = "title") String title,
            @RequestParam(name = "body") String body
    ){
        User user = userDao.getOne(1L);
        Posts post = new Posts(title,body);
        post.setOwner(user);
        Posts dbPost = postsDao.save(post);

        return "/posts/" + dbPost.getId();
    }

    @GetMapping("/posts/{id}/edit")
    public String showEditPost(@PathVariable long id, Model viewModel){
        viewModel.addAttribute("post", postsDao.getOne(id)); // mySql injection to find by id
        return "posts/edit";
    }

    @PostMapping("/posts/{id}/edit")
    @ResponseBody
    public String editPost(
            @PathVariable long id,
            @RequestParam(name = "title") String title,
            @RequestParam(name = "body") String body
    ){
        Posts dbPost = postsDao.getOne(id);
        dbPost.setTitle(title);
        dbPost.setBody(body);
        postsDao.save(dbPost);

        return "/posts/" + dbPost.getId();
    }

    @PostMapping("/posts/{id}/delete")
    public String deletePost(@PathVariable long id){
        postsDao.deleteById(id);
        return "posts/index";
    }
}
