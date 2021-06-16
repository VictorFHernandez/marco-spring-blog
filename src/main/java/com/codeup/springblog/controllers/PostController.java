package com.codeup.springblog.controllers;

import com.codeup.springblog.daos.EmailService;
import com.codeup.springblog.daos.UserRepository;
import com.codeup.springblog.models.Post;
import com.codeup.springblog.daos.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class PostController {
    private final PostRepository postDao;
    private final UserRepository userDao;
    private final EmailService emailService;


    public PostController(PostRepository postDao, UserRepository userDao, EmailService emailService) {
        this.postDao = postDao;
        this.userDao = userDao;
        this.emailService = emailService;
    }

    @GetMapping("/posts")
    public String viewAllPosts(Model model){
        model.addAttribute("posts", postDao.findAll());
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String viewOnePost(@PathVariable int id, Model model){
        model.addAttribute("singlePost", postDao.getById(id));
        return "posts/show";
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String showCreateForm(Model model) {
        model.addAttribute("ad", new Post());
        return "ads/create";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String CreatePost(){
        return "create a new post";
    }

    @PostMapping("/posts")
    @ResponseBody
    public  String postEdit(){
        return "edit posts";
    }

    @PostMapping("/post/delete")
    @ResponseBody
    public String postDelete(){
        return "delete post";
    }


}
