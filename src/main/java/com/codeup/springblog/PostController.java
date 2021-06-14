package com.codeup.springblog;

import org.dom4j.rule.Mode;
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

    public PostController(PostRepository postDao) {
        this.postDao = postDao;
    }



    @GetMapping("/posts")
    public String viewAllPosts(Model model){
        List<Post> posts = new ArrayList<>(Arrays.asList(
                new Post("Title1", "Body1"),
                new Post("Title2", "Body2")
        ));
        model.addAttribute("posts", posts);
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String viewOnePost(@PathVariable int id, Model model){
        Post post = new Post("requested post", "requested body");
        model.addAttribute("post", post);
        return "posts/show";
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
