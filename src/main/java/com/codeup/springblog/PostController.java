package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {

    @GetMapping("/posts")
    @ResponseBody
    public String postIndex(){
        return "Index page all for all the posts";
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String postId(@PathVariable int id){
        return "Post with the id of " + id + "!";
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String postCreation(){
        return "display form to create a new post";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String CreatePost(){
        return "create a new post";
    }
}
