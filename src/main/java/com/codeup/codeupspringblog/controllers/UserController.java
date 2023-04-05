package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.model.User;
import com.codeup.codeupspringblog.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    private UserRepository userDao;
    private PasswordEncoder passwordEncoder;


    public UserController(UserRepository userDao, PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/sign-up")
    public String showSignupForm(Model model){
        model.addAttribute("user", new User());
        return "users/sign-up";
    }

    @PostMapping("/sign-up")
    public String saveUser(@ModelAttribute User user){
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        userDao.save(user);
        System.out.println("is this working");
        return "redirect:/login";
    }

//    @GetMapping("/users/login")
//    public String userLoginPage(){
//
//        return ("/users/login");
//    }

//    @PostMapping("/users/login")
//    public String userLogin(@RequestParam String userName, @RequestParam String password) {
//
//        //// if else statement, username and password = username passoword , else redirect to login
//
//
//        return ("redirect:/posts/show");
//    }


}