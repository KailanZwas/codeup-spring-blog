package com.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AboutConterooler {

    @GetMapping("/about")
    public String aboutPage(@RequestParam int num){
        System.out.println(num);
        return "about";
    }


}
