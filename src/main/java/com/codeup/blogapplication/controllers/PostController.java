package com.codeup.blogapplication.controllers;

import com.codeup.blogapplication.models.Posts;
import com.codeup.blogapplication.models.User;
import com.codeup.blogapplication.repos.PostsRepository;
import com.codeup.blogapplication.repos.UserRepository;
import com.codeup.blogapplication.services.EmailService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class PostController {

    private final EmailService emailService;
    private final PostsRepository postsDao;
    private final UserRepository userDao;

    public PostController(PostsRepository postsDao, UserRepository userDao, EmailService emailService){
        this.postsDao = postsDao;
        this.userDao = userDao;
        this.emailService = emailService;
    }




    @GetMapping("/rick-roll") //when rick-roll is typed into the url
    public String rickRoll() {
        // redirecting to an absolute url
        return "redirect:https://www.youtube.com/watch?v=dQw4w9WgXcQ"; //user gets redirected to this page
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
    public String viewCreatePost(Model viewModel){
        viewModel.addAttribute("post", new Posts());
        return "posts/new"; //This is the viewing form for creating a post
    }

    @PostMapping("posts/create")
    public String createPost(@ModelAttribute Posts postToBeSaved){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();;
        postToBeSaved.setOwner(user);
        Posts dbPost = postsDao.save(postToBeSaved);
        emailService.prepareAndSend(dbPost,"Post confirm","A post has been made"); //pass in the created post
        return "redirect:/posts/index";
    }

    @GetMapping("/posts/{id}/edit")
    public String showEditPost(@PathVariable long id, Model viewModel){
        viewModel.addAttribute("post", postsDao.getOne(id)); // mySql injection to find by id
        return "posts/edit";
    }

    @PostMapping("/posts/{id}/edit")
    public String editPost(@ModelAttribute Posts postToBeUpdated){
        User user = userDao.getOne(1L); //a user obj coming from a session
        postToBeUpdated.setOwner(user);
        postsDao.save(postToBeUpdated);
        return "redirect:/posts/index";
    }



    @PostMapping("/posts/{id}/delete")
    public String deletePost(@PathVariable long id){
        postsDao.deleteById(id);
        return "redirect:/posts/index";
    }
}
