package com.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CreateProductController {

    @GetMapping("/product/create")
    public String returnProductCreateView(){
        return "product";
    }

    @PostMapping("/product/create")
    public String insertProduct(@RequestParam String name, @RequestParam int price){
        System.out.println(name);
        System.out.println(price);
        ///create a product object from re   params
        /// print out the product
        //redirect to "/"

        return "redirect:/howdy";

    }
}
