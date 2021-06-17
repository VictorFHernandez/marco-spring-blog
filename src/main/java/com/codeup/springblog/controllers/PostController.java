package com.codeup.springblog.controllers;

import com.codeup.springblog.services.EmailService;
import com.codeup.springblog.daos.UserRepository;
import com.codeup.springblog.models.Post;
import com.codeup.springblog.daos.PostRepository;
import com.codeup.springblog.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String create(@ModelAttribute Post post) {
        User user = userDao.getById(1L);
        post.setOwner(user);
        postDao.save(post);
        emailService.prepareAndSend(post, "You just created a post", post.getBody());
        return "redirect:/posts/index";
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
