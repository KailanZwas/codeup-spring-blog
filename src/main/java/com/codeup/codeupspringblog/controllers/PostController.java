package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.model.Post;
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

    @GetMapping("/posts")
    public String postIndex(Model model){
        List<Post> posts = new ArrayList<>(Arrays.asList(
                new Post("apple", "something goes here"),
                new Post("pear", "what else can i say")
        ));

        model.addAttribute("posts", posts);
        return "posts/index";
    }


    @GetMapping("/posts/{id}")
    public String postId(@PathVariable long id, Model model){
    Post post = new Post("poppy", " poppy seed muffins");

    model.addAttribute("post", post);
//        return "view an individual post with id of " + id;
        return "posts/show";
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String postCreate(){
        return "view the form for creating a post";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String postCreatNew(){
        return "create a new post";
    }



}