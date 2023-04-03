package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.model.*;
import com.codeup.codeupspringblog.repositories.PostRepository;
import com.codeup.codeupspringblog.repositories.TagRepository;
import com.codeup.codeupspringblog.repositories.UserRepository;
import com.codeup.codeupspringblog.services.EmailService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class PostController {

    private PostRepository postDao;
    private UserRepository userDao;

    private TagRepository tagDao;

    private EmailService emailService;


    public PostController(PostRepository postDao, UserRepository userDao, TagRepository tagDao, EmailService emailService) {
        this.userDao = userDao;
        this.postDao = postDao;
        this.tagDao = tagDao;
        this.emailService = emailService;
    }


    @GetMapping("/posts")
    public String postIndex(Model model) {
//        List<Post> posts = new ArrayList<>(Arrays.asList(
//                new Post(1,"apple", "something goes here"),
//                new Post(2,"pear", "what else can i say")
//        ));
        List<Post> posts = postDao.findAll();

        model.addAttribute("posts", posts);
        return "posts/index";
    }


    @GetMapping("/posts/{id}")
    public String postId(@PathVariable long id, Model model) {
//    Post post = new Post(1,"poppy", " poppy seed muffins");
        Optional<Post> post = postDao.findById(id);
        model.addAttribute("post", post);

        return "posts/show";
    }




//    @PostMapping("/posts")

//    public String postCreate(@RequestParam String title, @RequestParam String body, @RequestParam(name = "tags") String tags) {
//        Set<Tag> tagSet = Tags.makeTagSet(tags);
//        Post post = new Post(title, body);
//        User user = userDao.findById(1L);
//        post.setUser(user);
//        if (tagSet.size() > 0) {
//            List<Tag> tagsToAdd = new ArrayList<>();
//            for (Tag tag : tagSet) {
//                Tag tagFromDb = tagDao.findByName(tag.getName());
//                if (tagFromDb == null) {
//                    tagsToAdd.add(tagDao.save(tag));
//                } else {
//                    tagsToAdd.add(tagFromDb);
//                }
//            }
//            tagSet.clear();
//            tagSet.addAll(tagsToAdd);
//            post.setTags(tagSet);
//        }
//        postDao.save(post);
//        System.out.println("title");
//        System.out.println("body");
//        return "redirect:/posts";
//    }

//    @GetMapping("posts/create")
//
//    public String returnPostCreateNew() {
//        return "posts/create";
//    }






// model binding

    @GetMapping("/posts/create")
    public String showCreateForm(Model model) {
        model.addAttribute("posts", new Post());
        return "posts/create";
    }


    @PostMapping("/posts/create")
    public String createPost(@ModelAttribute Post post, @RequestParam long id) {
        User user = userDao.findById(id);
    Post newpost = new Post(post.getTitle(),post.getBody(), user);
    emailService.prepareAndSend(newpost);
    postDao.save(newpost);
        // save the ad...
        // redirect  to the index with all the ads
        return ("redirect:/posts");
    }

//    @GetMapping("/posts/register")
//    public String createUser(){
//        emailService.prepareAndSend();
//        return ("/posts/register");
//    }



}
