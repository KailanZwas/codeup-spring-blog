package com.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("/howdy")
    public String returnHowdyPage(Model model) {
        model.addAttribute("name", "Justin");
//        model.addAllAttributes("name", "Justin");
        return "hello";
    }
}
